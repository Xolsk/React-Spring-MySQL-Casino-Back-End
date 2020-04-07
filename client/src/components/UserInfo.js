import React from "react";

export default class UserInfo extends React.Component {


    render() {

        return (

            <div className="userInfoWrapper" >
                <div>
                    <h1>Player</h1>
                    <p>Pepe</p>
                    <button>Modify Player Name</button>
                </div>
            </div>
        )
    }
}