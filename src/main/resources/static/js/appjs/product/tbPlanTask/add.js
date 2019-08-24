$().ready(function() {
	validateRule();
    time();
    getOrganiz();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/product/tbPlanTask/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}

function time() {
    laydate.render({
        elem: '#planDate'
        , calendar: true
    });
}
    function getOrganiz(){
        var data1={
            limit: 100,
            offset: 0
        }
        $.ajax({
            type:'get',
            url: '/sales/tbSellContract/list',
            data:data1,
            dataType:'json',
            success:function(msg){
                var html='<option value="public">其他</option>' ;
                if(msg.rows.length){

                    for(var i in msg.rows){
                        html+='<option value="'+msg.rows[i].contractGuid+'">'+msg.rows[i].constructionOrganiz+'</option>';
                    }
                    $('#constructionOrganiz')[0].outerHTML='<select id="constructionOrganiz"    data-live-search="true" ></select>'
                    $('#constructionOrganiz').html('<option value="">--请选择--</option>'+html).next().remove();
                    $('#constructionOrganiz').selectpicker({
                        'selectedText': 'cat'
                    })
                }
            }
        });
    }
$('.bootstrap-select').change(function () {
	alert("qqwqwq")
}) 

