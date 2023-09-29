import React, { PureComponent } from "react";
import { Link } from "react-router-dom";

export default class Sidebar extends PureComponent {
  componentWillMount() {
    if (window.location) {
      this.props.setTitle("Reward Points");

    }
  }
  render() {
    const { setTitle } = this.props;
    return (
      <ul className="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        <Link className="sidebar-brand d-flex align-items-center justify-content-center" onClick={() => setTitle("Reward Points")} to={"/"}>
          <div className="sidebar-brand-icon rotate-n-15">
            <i className="fas fa-laugh-wink"></i>
          </div>
          <div className="sidebar-brand-text mx-3">Account</div>
        </Link>
        <hr className="sidebar-divider my-0" />
        <li className="nav-item">
          <Link className="nav-link" onClick={() => setTitle("Reward Points")} to={"/"}>
            <i className="fas fa-fw fa-tachometer-alt"></i>
            <span>Reward Points</span>
          </Link>
        </li>
      </ul>
    );
  }
}
