import React, { Component } from 'react';
import './App.css';
// import Dropdown from './Dropdown.js';
import RegistrationForm from './RegistrationForm.js';

// как будто данные получили от бэк энд. Делают один умный компонент остальные вложенные тупые
// умный App, а Header будет тупой
// const menu = [
//   {
//     link: '/articles',
//     label: 'Articles'
//   },
//   {
//     link: '/contacts',
//     label: 'Contacts'
//   },
//   {
//     link: '/posts',
//     label: 'Posts'
//   }
// ];


class App extends Component {
  render() {
    return (
      <div className = 'App'>
        <RegistrationForm />
      </div>
    );
  }
}

export default App;
