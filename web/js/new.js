$(function() {
    var name,des,url;
    var x = 1;
    $(".next").click(function () {
        x += 1;

        if (x === 2) {
            name = $(".name input").val();
            des = $(".remake input").val();
            var val = $(".name>input").val();
            if (val) {
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
            $(".next").css("visibility", "hidden");
            $(".third").css("display", "block");
            $(".two").css("background-image", "url(http://localhost:8080/image/bg-0.png)");
            $(".three").css("background-image", "url(http://localhost:8080/image/bg-4.png)");
        }
    });
    $(".pre").click(function () {
        x -= 1;
        $("#content>div").css("display", "none");
        $(".next").css("visibility", "visible");
        if (x === 2) {
            $(".second").css("display", "block");
            $(".three").css("background-image", "url(http://localhost:8080/image/bg-2.png)");
            $(".two").css("background-image", "url(http://localhost:8080/image/bg-1.png)");
        }else if (x === 1) {
            $(".first").css("display", "block");
            $(".pre").css("visibility", "hidden");
            $(".two").css("background-image", "url(http://localhost:8080/image/bg-0.png)");
            $(".one").css("background-image", "url(http://localhost:8080/image/bg-1.png)");
        }
    });

    var url = $("#myselect").val();
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
                        if(i===0){
                            n = n.substr(1,n.length);
                        }else if(i===4){
                            n = n.substr(0,(n.length - 1));
                        }
                        var str = "<p>" + n + "</p>"
                        $("#container").append(str);
                    });
                    var str1 = "<p>共有" + data.number + "个图片下载完成</p>"
                    $("#container").append(str1);

                }
                if(data.numChange=="true"){
                    $("#end").css("display","block");
                    $(".third>i").css("display","none");
                    clearInterval(set1);
                }
            }
        })
	};

	$("#start").click(function () {
	    console.log(name,des,url);
        $("#stop").css("display","block");
        $(".third>i").css("display","block");
        $("#container").empty();
		$.ajax({
			url: "/start",
            data: {name:name,des:des,url:url},
			type:"get",
            success: function(data){
				if(data.sign=="interrupt"){
                    clearInterval(set1);
                }
            }
        });
		set1 = setInterval(function () {
            num += 1;
            ajax1(num);
        },3000);
    });
    $("#stop").click(function(){
        $("#stop").css("display","none");
        $(".third>i").css("display","none");
        $.ajax({
            url: "/stop",
            type: "get",
            success: function () {
                console.log("123");
            }
        })
    });

    $("#myselect").jSelect();

    $("#example>tbody>.odd").click(function () {
        alert(123)
        // $("#example .even").css("background-color","#b8cdea");
        // $("#example .odd").css("background-color","#fff");
        // $(this).css("background-color","#ccc");
    })
})


