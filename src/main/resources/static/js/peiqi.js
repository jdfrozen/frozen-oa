// JavaScript Document
var i=0;
window.onload=function(){
    var iNO = document.getElementById("iNO");
    var iOK = document.getElementById("iOK");
    var iBT = document.getElementById("iBT");
    var iPQ = document.getElementById("iPQ");
    iNO.onclick=function(){
        i++;
        if(i==1){
            iBT.innerHTML = "~ 这个呢 ~";
            iPQ.src="images/peiqi/2.jpg";
        }else if(i==2){
            iBT.innerHTML = "~ 这下是了吧~";
            iPQ.src="images/peiqi/3.jpg";
        }else if(i==3){
            iBT.innerHTML = "~ 最后一个了 ~";
            iPQ.src="images/peiqi/4.jpg";
            i=0;
        }
    }
    iOK.onclick=function(){
        window.location.href="/love"
    }

}