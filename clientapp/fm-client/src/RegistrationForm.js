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

	handleSubmit(event) {
		//для того что бы по нажатию на enter после ввода страница не перезагружалась
		event.preventDefault();

		console.log('Form is submitted. E-mail value is', this.state.email);
	}

	//что бы this нашего класса был доступен в нашей функции его нужно прибиндить,
	//для этого прибиндим его в конструкторе
	//event это событие нашего ввода, в котором содежрится значение value
	handleEmailChange(event) {
		console.log('E-mail was changed', event.target.value);
		this.setState({email: event.target.value});
	}

	//у button по умолчанию тип submit, поэтому вызывается submit формы
	//onSubmit={this.handleSubmit} который дергает функцию handleSubmit
	render() {
		return (
			<form onSubmit={this.handleSubmit}>
				<input
					type="text"
					placeholder="E-mail"
					value={this.state.email}
					onChange={this.handleEmailChange}
				/>
				<button>Save</button>
			</form>
			);
	}
}

export default RegistrationForm;