$(function(){
	$(".table-wrapper").panel({iWheelStep:32});
	var x = 1;
	$(".next").click(function(){
		x += 1;
		
		if(x===2){
			var name = $(".name>input").val();
			if(name){
				$("#content>div").css("display","none");
				$(".pre").css("visibility","visible");
				$(".second").css("display","block");
				$(".one").css("background-image","url(http://localhost:8080/image/bg-0.png)");
				$(".two").css("background-image","url(http://localhost:8080/image/bg-1.png)");
			}else{
				x = 1;
				alert("任务名称不能为空");
			}
		}else if(x===3){
			$("#content>div").css("display","none");
			$(".third").css("display","block");
			$(".two").css("background-image","url(http://localhost:8080/image/bg-0.png)");
			$(".three").css("background-image","url(http://localhost:8080/image/bg-1.png)");
		}else if(x===4){
			$("#content>div").css("display","none");
			$(".fourth").css("display","block");
			$(".next").css("visibility","hidden");
			$(".three").css("background-image","url(http://localhost:8080/image/bg-0.png)");
			$(".four").css("background-image","url(http://localhost:8080/image/bg-4.png)");
		}
	});
	$(".pre").click(function(){
		x -= 1;
		$("#content>div").css("display","none");
		$(".next").css("visibility","visible");
		$(".pre").css("visibility","visible");
		$("#content>div").css("display","none");
		if(x===2){
			$(".second").css("display","block");
			$(".three").css("background-image","url(http://localhost:8080/image/bg-0.png)");
			$(".two").css("background-image","url(http://localhost:8080/image/bg-1.png)");
		}else if(x===3){
			$(".third").css("display","block");
			$(".four").css("background-image","url(http://localhost:8080/image/bg-2.png)");
			$(".three").css("background-image","url(http://localhost:8080/image/bg-1.png)");
		}else if(x===1){
			$(".first").css("display","block");
			$(".pre").css("visibility","hidden");
			$(".two").css("background-image","url(http://localhost:8080/image/bg-0.png)");
			$(".one").css("background-image","url(http://localhost:8080/image/bg-1.png)");
		}
	});
	function del(){
		$(this).parents("tr").remove();
	}
	$(".del").click(del);

	$("#add").click(function(){
		var name = $(this).siblings("input").val();
		if(name){
			var str = "";
				str += ""
					+  "<tr>"
					+	"<td>自定义字段</td>"
					+	"<td>"+name+"</td>"
					+	"<td><img class='del' src='http://localhost:8080/image/del.png' alt=''></td>"
					+  "</tr>"

			$("tbody").append(str);
			$(".del").click(del);
		}else{
			alert("输入不能为空")
		}
	});
	$("#start").click(function () {

		$.ajax({
			url: "/hello",
			type:"get"
		})
		alert("nihao");
    });
})