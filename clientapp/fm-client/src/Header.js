import React, { Component, PropTypes } from 'react';


class Header extends Component {
	
	//описываем что хотим получить в компонент с родителя или бэка
	//что бы компонент заработал. Просим массив и это обязательные данные.
	//например, что бы не передали строку вместо ожидаемого типа параметра.
	static propTypes = {
		items: PropTypes.array.isRequired;

	};

	render() {
		console.log('items', this.props.items);
		return(
			<div>
				{this.props.items.map((item, index) => 
					<a href={item.link} key={index}>{item.label}</a>
				)}
			</div>
		); 		
	}

}

export default Header;