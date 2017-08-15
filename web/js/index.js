var createTime = "";
function detail(that) {
        $("#detail-wrapper").fadeIn();
        var name = $(that).parents("tr").children("td:nth-child(2)").text();
        var desc = $(that).parents("tr").children("td:nth-child(3)").text();
        var url = $(that).parents("tr").children("td:nth-child(4)").text();
        var time = $(that).parents("tr").children("td:nth-child(5)").text();
        $("#detail").children("p:first-child").children("span").text(name);
        $("#detail").children("p:nth-child(2)").children("span").text(desc);
        $("#detail").children("p:nth-child(3)").children("span").text(url);
        $('#example').empty();
        createTime = time;
        console.log(createTime);
        mytable.ajax.url("/list_detail.jsp?createTime="+createTime).load();
}
$(function () {

    $(".close").click(function () {
        $("#detail-wrapper").fadeOut();
    });
})

