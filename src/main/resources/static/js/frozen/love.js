// JavaScript Document
var i=0;
window.onload=function(){
    var iNO = document.getElementById("iNO");
    var iOK = document.getElementById("iOK");
    var iTEXT = document.getElementById("iTEXT");
    iNO.onclick=function(){
        i++;
        if(i==1){
            iTEXT.innerHTML = "~ 你是我见过最善良可爱的女孩 ~";
        }else if(i==2){
            iTEXT.innerHTML = "~ 保大 ~";
        }else if(i==3){
            iTEXT.innerHTML = "~ 我妈会游泳 ~";
        }else if(i==4){
            iTEXT.innerHTML = "~ 家务我全干 ~";
        }else if(i==5){
            iTEXT.innerHTML = "~ 不藏私房钱 ~";
        }else if(i==6){
            iTEXT.innerHTML = "~ 房子写你名 ~";
        }else if(i==7){
            iTEXT.innerHTML = "~ 小姐姐在考虑一下呗 ~";
            i=0;
        }
    }
    iOK.onclick=function(){
        iTEXT.innerHTML = "同意了，爱你呦~~~";
    }

}