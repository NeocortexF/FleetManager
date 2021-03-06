import * as React from 'react';
import './App.css';
import PilotList from './PilotList';

const logo = require('./logo.svg');

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <PilotList/>
      </div>
    );
  }
}

export default App;
