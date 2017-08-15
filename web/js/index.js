function detail(that) {
    if(that){
        $("#detail-wrapper").fadeIn();
        var name = $(that).parents("tr").children("td:nth-child(2)").text();
        var desc = $(that).parents("tr").children("td:nth-child(3)").text();
        var url = $(that).parents("tr").children("td:nth-child(4)").text();
        var time = $(that).parents("tr").children("td:nth-child(5)").text();
        $("#detail").children("p:first-child").children("span").text(name);
        $("#detail").children("p:nth-child(2)").children("span").text(desc);
        $("#detail").children("p:nth-child(3)").children("span").text(url);

        var table = $('#example').DataTable({
            ajax: {
                url: "/list_content.jsp",
                data: time
            },
            "order": [[1, 'asc']],// dt默认是第一列升序排列 这里第一列为序号列，所以设置为不排序，并把默认的排序列设置到后面
            "serverSide": true,
            "columns": [
                {"data": "ID"},
                {"data": "TITLE"},
                {"data": "PATH"},
                {"data": "TYPE"},
                {"data": "CREATED_AT"}

            ],
            "columnDefs": [
                {
                    "searchable": false,
                    "orderable": false,
                    "targets": [0.-1]
                }
            ],

            "language": {
                "lengthMenu": "每页_MENU_ 条记录",
                "zeroRecords": "没有找到记录",
                "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                "infoEmpty": "无记录",
                "search": "搜索：",
                "infoFiltered": "(从 _MAX_ 条记录过滤)",
                "paginate": {
                    "previous": "上一页",
                    "next": "下一页"
                }
            }

        });

        //添加序号
        //不管是排序，还是分页，还是搜索最后都会重画，这里监听draw事件即可
        table.on('draw.dt',function() {
            table.column(0, {
                search: 'applied',
                order: 'applied'
            }).nodes().each(function(cell, i) {
                //i 从0开始，所以这里先加1
                i = i+1;
                //服务器模式下获取分页信息
                var page = table.page.info();
                //当前第几页，从0开始
                var pageno = page.page;
                //每页数据
                var length = page.length;
                //行号等于 页数*每页数据长度+行号
                var columnIndex = (i+pageno*length);
                cell.innerHTML = columnIndex;
            });
        }).draw();
    }


}
$(function () {

    $(".close").click(function () {
        $("#detail-wrapper").fadeOut();
    });
})

