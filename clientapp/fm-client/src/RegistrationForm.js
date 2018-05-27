import React, { Component } from 'react';

class RegistrationForm extends Component {

	//дефолтное значение для e-mail пустая строка
	constructor(props) {
		super(props);
		this.state = {
			email: ''
		};
		//что бы this ссылался не на функцию, а на экземпляр класса
		//просто говоря, если не сделать то будет undefinded, а так
		//будет ссылаться имено на форму регистрации и можно будет получать данные
		this.handleEmailChange = this.handleEmailChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit() {
		console.log('Form is submitted');
	}

	//что бы this нашего класса был доступен в нашей функции его нужно прибиндить,
	//для этого прибиндим его в конструкторе
	handleEmailChange() {
		console.log('E-mail was changed', this);
	}

	render() {
		return (
			<form onSubmit={this.handleSubmit}>
				<input
					type="text"
					placeholder="E-mail"
					value={this.state.email}
					onChange={this.handleEmailChange}
				/>
			</form>
			);
	}
}

export default RegistrationForm;