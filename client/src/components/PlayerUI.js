import React from "react";
import UserInfo from "./UserInfo"
import RollMaker from "./RollMaker"
import PlayerList from "./PlayerList"
import { Redirect } from "react-router-dom";

export default class PlayerUI extends React.Component {

    constructor(props) {
        super(props)
        this.state = { redirect: false }
        this.logout = this.logout.bind(this);
    }

    componentDidMount() {

        console.log(this.props.isLogged)
        if (this.props.isLogged === false) {

            this.setState({ redirect: true });
        }

    }

    logout() {

        this.props.logUser();
        sessionStorage.clear();
        this.setState({ redirect: true });
    }
    render() {

        return (

            this.state.redirect === true ? <Redirect to="/" /> :
                <div className="generalWrapper">
                    <div className="playerUI">
                        <RollMaker />
                        <div className="playerUIColumn">
                            <UserInfo />
                            <PlayerList />
                        </div>
                    </div>
                    <div>HOLA
                <button onClick={this.logout}>Log Out</button>
                    </div>

                </div>
        )
    }
}