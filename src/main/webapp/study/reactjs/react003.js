
/**
 * @author yusik
 * @date 03/18/2018
 * react styling
 */

var destination = document.querySelector('#container');

// version 16부터 class
class Letter extends React.Component {
    render() {

        var letterStyle = {
            padding: 10,
            margin: 10,
            backgroundColor: this.props.bgcolor,
            color: "#333",
            display: "inline-block",
            fontFamily: "monospace",
            fontSize: 32,
            textAlign: "center"
        };

        return (
            <div style={letterStyle}>
                {this.props.children}
            </div>
        );
    }
}
//
// var Buttonify = React.createClass({
//     render: function() {
//         return (
//             <div>
//                 <button type={this.props.behavior}> {this.props.children} </button>
//             </div>
//         );
//     }
// });


ReactDOM.render(
    <div>
        <Letter bgcolor="#58B3FF">A</Letter>
        <Letter>E</Letter>
        <Letter>I</Letter>
        <Letter>O</Letter>
        <Letter>U</Letter>
    </div>
    , destination
);

// virtual dom
setTimeout(function() {
    ReactDOM.render(
        <div>
            <Letter bgcolor="#58B3FF">A1</Letter>
            <Letter bgcolor="#FF605F">E2</Letter>
            <Letter bgcolor="#FFD52E">I3</Letter>
            <Letter bgcolor="#49DD82">O4</Letter>
            <Letter bgcolor="#AE99FF">U5</Letter>
        </div>
        , destination
    );
}, 4000);