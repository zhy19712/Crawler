$(function() {
    $(".table-wrapper").panel({iWheelStep: 32});
    var x = 1;
    $(".next").click(function () {
        x += 1;

        if (x === 2) {
            var name = $(".name>input").val();
            if (name) {
                $("#content>div").css("display", "none");
                $(".pre").css("visibility", "visible");
                $(".second").css("display", "block");
                $(".one").css("background-image", "url(http://localhost:8080/image/bg-0.png)");
                $(".two").css("background-image", "url(http://localhost:8080/image/bg-1.png)");
            } else {
                x = 1;
                alert("任务名称不能为空");
            }
        } else if (x === 3) {
            $("#content>div").css("display", "none");
            $(".third").css("display", "block");
            $(".two").css("background-image", "url(http://localhost:8080/image/bg-0.png)");
            $(".three").css("background-image", "url(http://localhost:8080/image/bg-1.png)");
        } else if (x === 4) {
            $("#content>div").css("display", "none");
            $(".fourth").css("display", "block");
            $(".next").css("visibility", "hidden");
            $(".three").css("background-image", "url(http://localhost:8080/image/bg-0.png)");
            $(".four").css("background-image", "url(http://localhost:8080/image/bg-4.png)");
        }
    });
    $(".pre").click(function () {
        x -= 1;
        $("#content>div").css("display", "none");
        $(".next").css("visibility", "visible");
        $(".pre").css("visibility", "visible");
        $("#content>div").css("display", "none");
        if (x === 2) {
            $(".second").css("display", "block");
            $(".three").css("background-image", "url(http://localhost:8080/image/bg-0.png)");
            $(".two").css("background-image", "url(http://localhost:8080/image/bg-1.png)");
        } else if (x === 3) {
            $(".third").css("display", "block");
            $(".four").css("background-image", "url(http://localhost:8080/image/bg-2.png)");
            $(".three").css("background-image", "url(http://localhost:8080/image/bg-1.png)");
        } else if (x === 1) {
            $(".first").css("display", "block");
            $(".pre").css("visibility", "hidden");
            $(".two").css("background-image", "url(http://localhost:8080/image/bg-0.png)");
            $(".one").css("background-image", "url(http://localhost:8080/image/bg-1.png)");
        }
    });
    function del() {
        $(this).parents("tr").remove();
    }

    $(".del").click(del);

    $("#add").click(function () {
        var name = $(this).siblings("input").val();
        if (name) {
            var str = "";
            str += ""
                + "<tr>"
                + "<td>自定义字段</td>"
                + "<td>" + name + "</td>"
                + "<td><img class='del' src='http://localhost:8080/image/del.png' alt=''></td>"
                + "</tr>"

            $("tbody").append(str);
            $(".del").click(del);
        } else {
            alert("输入不能为空")
        }
    });
    var num = 0;
    var set1;
    function ajax1(num){
		$.ajax({
            url: "/data",
            type: "get",
            data: num,
            dataType: "json",
            success: function (data) {
                if (data.number>0){
                    $("#container").empty();
                    console.log(typeof(data.str))
                    var arr = data.str.split(",");
                    $.each(arr,function (i,n) {

                        var str = "<p>" + n + "</p>"
                        $("#container").append(str);
                    });
                    var str1 = "<p>共有" + data.number + "个图片下载完成</p>"
                    $("#container").append(str1);

                }

            }
        })
	};

	$("#start").click(function () {
        $("#stop").css("display","block");
        $(".fourth>i").css("display","block");
		$.ajax({
			url: "/start",
			type:"get",
            success: function(data){
				alert(data.str);
				$("222").html(data);
            }
        });
		set1 = setInterval(function () {
            num += 1;
            ajax1(num);
        },3000);
    });
    $("#stop").click(function(){
        $("#stop").css("display","none");
        $(".fourth>i").css("display","none");
        clearInterval(set1);
        $.ajax({
            url: "/stop",
            type: "get",
            success: function () {
                console.log("123");
            }
        })
    });
})


