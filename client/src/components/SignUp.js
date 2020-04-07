import React from "react";

export default class SignUp extends React.Component {

    constructor(props) {
        super(props);
        this.state = { username: "", password: "" };
        this.handleUserChange = this.handleUserChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleUserChange(event) {
        this.setState({ username: event.target.value });
    }

    handlePasswordChange(event) {
        this.setState({ password: event.target.value });
    }

    handleSubmit(event) {
       event.preventDefault();
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        const username=this.state.username;
        const password=this.state.password;
        const raw= JSON.stringify({username,password});
        const requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        fetch("http://localhost:8080/api/players/secure/register", requestOptions)
            .then(response => response.json())
            .then(result => alert(result.message))
            .catch(error => console.log('error', error));
    }

    render() {

        return (

            <div className="homeColumn">
                <h1>Sign Up</h1>
                <form onSubmit={this.handleSubmit}>
                    <label>Username:</label>
                    <input type="text" name="username"
                        value={this.state.username}
                        onChange={this.handleUserChange}>
                    </input>
                    <label>Password:</label>
                    <input type="password"
                        name="password"
                        value={this.state.password}
                        onChange={this.handlePasswordChange}
                    ></input>
                    <button type="submit">Sign Up to the the Gran Casino!</button>
                </form>
            </div>
        )
    }
}