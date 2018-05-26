import React, { Component } from 'react';

class Dropdown extends Component {
	constructor(props) {
		super(props);
		this.state = { isOpened: false };
	}

	toggleState() {
		this.setState({ isOpened: !this.state.isOpened });
	}

	render() {
		console.log('isOpened', this.state.isOpened);
		let dropdownText;
		
		if (this.state.isOpened) {
			dropdownText = <div>Opened dropdown</div>;
		}

		return (
			<div onClick={this.toggleState.bind(this)}>
			Its dropdown
			{dropdownText}
			</div>
		);
	}
}

export default Dropdown;