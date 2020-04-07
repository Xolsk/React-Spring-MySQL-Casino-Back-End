import React from "react";
import {Redirect} from "react-router-dom";

export default class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state = { username: "", password: "", redirect:false };
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

        fetch("http://localhost:8080/api/players/secure/authenticate", requestOptions)
            .then(response => response.json())
            .then((result =>{
                             if (result.status===401)
                             {
                                 alert("Access Denied");
                               
                             }
                             else
                             {
                             this.props.logUser();
                             this.setState({redirect:true});
                             sessionStorage.setItem("token",JSON.stringify(result.token));
                            }
            }))
            .catch(error => console.log('error', error));
    }
    

    render() {

        return (

            this.state.redirect===true? <Redirect to ="/PlayerUI"/>:
            <div className="homeColumn">
                <h1>Login</h1>
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
                    <button type="submit">Log In to the the Gran Casino!</button>
                </form>
            </div>
        )
    }
}