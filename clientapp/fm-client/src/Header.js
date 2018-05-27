import React, { Component, PropTypes } from 'react';


class Header extends Component {
	
	//описываем что хотим получить в компонент с родителя или бэка
	//что бы компонент заработал. Просим массив и это обязательные данные.
	//например, что бы не передали строку вместо ожидаемого типа параметра.
	//валидация получаемых данных, просто примеры
	// static propTypes = {
	// 	items: PropTypes.array.isRequired,
	// 	isLoading: PropTypes.bool,
	// 	submit: PropTypes.func.isRequired,
	// 	title: PropTypes.string.isRequired,
	// 	type: PropTypes.oneOf(['news', 'photos']),
	// 	user: PropTypes.shape({
	// 		name: PropTypes.string,
	// 		age: PropTypes.number
	// 	}),
	// 	users: PropTypes.arrayOf({
	// 		name: PropTypes.string,
	// 		age: PropTypes.number
	// 	})
	// };

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