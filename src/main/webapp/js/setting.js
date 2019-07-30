// JavaScript Document
;$(function(){
	$("#dry_switch").click(function(){ $("#set-test").toggle(); })
})
$(function(){
	time1 = document.getElementsByTagName("input")[0];
	time2 = document.getElementsByTagName("input")[1];
	time2.onblur = function(){
		if(time1.value >= time2.value){
			time1.style.borderColor = "#FF6666";
			time2.style.borderColor = "#FF6666";
		}
		else{
			time1.style.borderColor = "#CACACA";
			time2.style.borderColor = "#CACACA";
		}
	}
})
