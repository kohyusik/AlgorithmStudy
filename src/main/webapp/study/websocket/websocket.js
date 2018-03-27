
/**
 * @author yusik
 * @date 03/27/2018
 * react start
 */

{
    var ws = new WebSocket('ws://localhost:8080/ws.server');
    ws.onmessage = function(e) {
        console.log(e);
    };

    var colorLabel = document.querySelector('#container p');
    colorLabel.addEventListener('click', function(e) {
        console.log(e);
        ws.send(e.srcElement.innerHTML);
    });
}