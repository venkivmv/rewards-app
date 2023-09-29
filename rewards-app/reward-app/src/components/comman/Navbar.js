import React, { PureComponent } from "react";

export default class Navbar extends PureComponent {
  render() {
    return (
      <nav className="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
        <div>
          <h6>{this.props.title}</h6>
        </div>
      </nav>
    );
  }
}
