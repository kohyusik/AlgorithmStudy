
/**
 * @author yusik
 * @date 03/27/2018
 * react start
 */

{
    var ws = new WebSocket('ws://localhost:9999/ws.server');
    ws.onmessage = function(e) {
        console.log(e.data);
    };

    var colorLabelList = document.querySelectorAll('#container p');
    for (var i = 0, max = colorLabelList.length; i < max; i++) {
        colorLabelList[i].addEventListener('click', function(e) {
            // console.log(e);
            ws.send(e.srcElement.innerHTML);
        });
    }
}