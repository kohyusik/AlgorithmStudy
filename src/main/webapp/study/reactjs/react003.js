
/**
 * @author yusik
 * @date 03/18/2018
 * react styling
 */

var destination = document.querySelector('#container');

class Letter extends React.Component {
    render() {

        var letterStyle = {
            padding: 10,
            margin: 10,
            backgroundColor: "#ffde00",
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
        <Letter>A</Letter>
        <Letter>E</Letter>
        <Letter>I</Letter>
        <Letter>O</Letter>
        <Letter>U</Letter>
    </div>
    , destination
);

setTimeout(function() {
    ReactDOM.render(
        <div>
            <Letter>A1</Letter>
            <Letter>E2</Letter>
            <Letter>I3</Letter>
            <Letter>O4</Letter>
            <Letter>U5</Letter>
        </div>
        , destination
    );
}, 3000);