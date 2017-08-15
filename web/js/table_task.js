var table;
$(function () {

    table = $('#task').DataTable({
        ajax: {
            url: "/list_task.jsp"
        },
        "order": [[1, 'asc']],
        "serverSide": true,
        "columns": [
            {"data": "ID"},
            {"data": "NAME"},
            {"data": "DESCRIPTION"},
            {"data": "URL"},
            {"data": "CREATED_AT"},
            {"data": null}

        ],
        "columnDefs": [
            {
                "searchable": false,
                "orderable": false,
                "targets": [0.-1],
                "render" : function (data) {
                    return "<div class='detail' onclick='detail(this)'><img src='/image/detail.png' alt=''><span>详情</span></div><div class='delete'><img src='/image/delete.png' alt=''><span>删除</span></div>"
                }
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

});


