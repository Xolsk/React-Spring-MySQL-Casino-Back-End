import React from 'react';
import { BrowserRouter as Router, Route,Switch } from "react-router-dom";
import Home from "./components/Home";
import PlayerUI from "./components/PlayerUI";

import './App.css';

class App extends React.Component{

  constructor(props){
    super(props)
    this.state={loggedUser:false}
    this.logUser = this.logUser.bind(this);
  }

  logUser=()=>{

    this.setState({loggedUser:!this.state.loggedUser})

  }

    
  render(){
  return (
    <div className="App">
      <div className="welcome">
      <h1>THE GRAN CASINO!</h1>
      </div>
      <Router>
        <Switch>
        <Route  path="/playerUI" render={(props)=><PlayerUI {...props} isLogged={this.state.loggedUser} logUser={this.logUser}/>}></Route>
        <Route  exact path="/" render={(props)=><Home {...props} logUser={this.logUser}/>}></Route>
        </Switch>
      </Router>

    </div>
    

  );
  }
}

export default App;
