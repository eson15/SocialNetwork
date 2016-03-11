//这里是我们自己的一个Js函数库

function changeStatus(obj){
	if(obj.value == "worker") {
		$(".spe_worker").show();
		$(".spe_graduate").hide();
	}
	else if(obj.value == "graduate") {
		//根据Id去寻找
//		$(".spe_graduate").css("display", "table-row");//显示tr，必须用table-row
		$(".spe_graduate").show();
		$(".spe_worker").hide();
	}
}
