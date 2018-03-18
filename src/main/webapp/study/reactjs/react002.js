
var destination = document.querySelector('#container');


var HelloWorld = React.createClass({
    render: function() {
        return (
            <p>Hello, {this.props.bowTarget}</p>
        );
    }
});

ReactDOM.render(
    <div>
    <HelloWorld bowTarget='TEST'/>
    <HelloWorld bowTarget='TEST2'/>
    <HelloWorld bowTarget='TEST3'/>
    <HelloWorld />
    </div>
    , destination
);

// 16 version 부터 createClass 없어짐
// class HelloWorld extends React.Component {
//     render() {
//         return (
//             <p>Hello, componentized world!</p>
//         );
//     }
// }

/*

// replace React.createClass with a class:
class InputControl extends React.Component {
    // Use static properties for propTypes/defaultProps
    static propTypes = {
        initialValue: PropTypes.string
    }

    static defaultProps = {
        initialValue: ''
    }

    // Initialize state right in the class body,
    // with a property initializer:
    state = {
        text: this.props.initialValue || 'placeholder'
    }

    // Use an arrow function to preserve the "this" binding
    // without having to bind in the constructor, or in render.
    handleChange = (event) => {
        this.setState({
            text: event.target.value
        });
    }

    // In classes, functions are written without
    // the 'function' keyword. Also, notice there are no commas
    // between properties
    render() {
        return (
            <div>
                Type something:
                <input onChange={this.handleChange}
                       value={this.state.text} />
            </div>
        );
    }
}

*/
