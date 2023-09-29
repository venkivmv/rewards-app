import React, { Component } from "react";
import { Request } from "../../helper/Request";
import { getDays, SEARCH_DATE } from "../../helper/Util";
import { AccountInfo, AccountDetails, Search, SearchInfo } from "./AccountDetails";
import { createQueryStr, GET_ALL_REWARDS, GET_PURCHASE_BY_CUSTOMER, GET_TOTAL_REWARDS } from "./UrlConstants";

export default class Account extends Component {
  state = {
    selectedDate: "",
    isSearch: false,
    isAccountDetails: false,
    customer: [],
    transectionHistory: [],
    totalReward: 0,
    sid: 0,
  };

  start = "";
  end = "";

  updateState = (data) => {
    this.setState(data);
  };

  componentWillMount() {
    this.state.selectedDate = SEARCH_DATE.year + "-" + SEARCH_DATE.month;
  }

  onSearchClick = () => {
    const { selectedDate } = this.state;
    if (selectedDate) {
      this.setState({ customer: [], transectionHistory: [], isSearch: false, isAccountDetails: false });
      const dates = getDays(this.state.selectedDate);
      this.start = dates.start;
      this.end = dates.end;
      const dt = createQueryStr(dates);
      const url = GET_ALL_REWARDS + dt;
      const url2 = GET_TOTAL_REWARDS + dt;
      Request.get(url2, (data, err) => {
        if (data) {
          const rewards = parseInt(data);
          if (!Number.isNaN(rewards)) this.setState({ totalReward: rewards });
          else this.setState({ totalReward: 0 });
        }
      });
      Request.get(url, (data, err) => {
        if (data) {
          this.setState({
            customer: JSON.parse(data),
          });
        } else {
          this.setState({ customer: [] });
        }
        this.setState({ isSearch: true, isAccountDetails: false });
      });
    }
  };

  onSelectCustomer = (id) => {
    this.setState({ sid: id });
    const url = GET_PURCHASE_BY_CUSTOMER + id + createQueryStr({ start: this.start, end: this.end });
    Request.get(url, (data, err) => {
      if (data) {
        this.setState({ transectionHistory: JSON.parse(data) });
      }
    });
  };

  render() {
    const { customer, transectionHistory, selectedDate, isSearch, sid, isAccountDetails, totalReward } = this.state;
    return (
      <div className="row">
        <Search updateState={this.updateState} onSearchClick={this.onSearchClick} selectedDate={selectedDate} />
        <div className="col-12">
          {isSearch ? (
            <div className="card shadow mb-4">
              <div className="card-header py-3">
                <div className="row">
                  <SearchInfo total={totalReward} selectedDate={selectedDate} />
                </div>
              </div>
              <div className="card-body">
                <div className="row">
                  <div className="col-6 rounded">
                    {customer.length ? (
                      <div>
                        {customer.map((e, i) => (
                          <AccountInfo onSelectCustomer={this.onSelectCustomer} key={i} sid={sid} {...e} />
                        ))}
                      </div>
                    ) : null}
                    {!customer.length && isSearch ? <div className="m-auto">No Transection Found</div> : null}
                  </div>
                  <div className="col-6 bg-white rounded">
                    {transectionHistory && transectionHistory.length ? (
                      <table className="table">
                        <thead>
                          <tr>
                            <th>Amount</th>
                            <th>Purchase Date</th>
                            <th>Reward</th>
                          </tr>
                        </thead>
                        <tbody>
                          {transectionHistory.map((e, i) => (
                            <AccountDetails key={i} {...e} />
                          ))}
                        </tbody>
                      </table>
                    ) : null}
                    {!transectionHistory.length && isAccountDetails ? <div className="m-auto">No Transection Found</div> : null}
                  </div>
                </div>
              </div>
            </div>
          ) : null}
        </div>
      </div>
    );
  }
}
