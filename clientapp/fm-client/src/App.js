import React, { Component } from 'react';
import './App.css';
// import Dropdown from './Dropdown.js';
import Header from './Header.js';

// как будто данные получили от бэк энд. Делают один умный компонент остальные вложенные тупые
// умный App, а Header будет тупой
const menu = [
  {
    link: '/articles',
    label: 'Articles'
  },
  {
    link: '/contacts',
    label: 'Contacts'
  },
  {
    link: '/posts',
    label: 'Posts'
  }
];


class App extends Component {
  render() {
    return (
      <div className = 'App'>
        <Header items={menu} />
      </div>
    );
  }
}

export default App;
