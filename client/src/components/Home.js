import React from "react";
import Login from "./Login";
import SignUp from "./SignUp";

export default class Home extends React.Component {


    render() {

        return (

            <div className="homeWrapper">
                <Login logUser={this.props.logUser} />
                <SignUp />
            </div>
        )
    }
}