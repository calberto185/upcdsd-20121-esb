$(document).ready(function(){
	setTimeout(init,1500);
});
function init(){
	startAnimation();
}
function startAnimation(){
	setTimeout(startRose,500);
	setTimeout(startTang,1000);
	setTimeout(startYellow,1250);
	setTimeout(startOrange,1500);
	setTimeout(startRed,1750);
	setTimeout(revealText,3000);
}
// animation first stage
function nextYellow(){
	$('#yellow').animate({width:"620px",height:"288px"},1000);
}
function nextTang(){
	$('#tangerine').animate({width:"225px",height:"320px"},750);
}
function nextOrange(){
	$('#orange').animate({width:"608px",height:"345px"},500);
}
function nextRed(){
	$('#red').animate({width:"151px",height:"100px"},800);
}
function nextRose(){
	$('#rose').animate({width:"630px",height:"60px"},1400);
}
// animation second stage
function startYellow(){
	$('#yellow').animate({width:"340px",height:"330px"},1000,nextYellow());
}
function startTang(){
	$('#tangerine').animate({width:"410px",height:"320px"},750,nextTang());
}
function startOrange(){
	$('#orange').animate({width:"300px"},500,nextOrange());
}
function startRed(){
	$('#red').animate({width:"600px"},800,nextRed());
}
function startRose(){
	$('#rose').animate({width:"620px"},1400,nextRose());
}
function revealText(){
	/*alert('text box triggered');*/
	$('#textbox').fadeIn(1000);
}

// @@ END Homepage feature 2
