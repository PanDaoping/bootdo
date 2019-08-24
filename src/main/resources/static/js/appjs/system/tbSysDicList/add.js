$().ready(function() {
	validateRule();
    typeTagName();
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
		url : "/system/tbSysDicList/save",
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

function typeTagName(){
    $.ajax({
        type: "GET",
        url: "/system/tbSysDic/list?limit=1000&offset=0",
        success: function (data) {
            if(data.rows){
                var opt='<option value="">--请选择--</option>'
                for(var i in data.rows){
                    opt+='<option value="'+data.rows[i].typeTag+'">'+data.rows[i].typeName+'</option>'
                }
                $('#typeTag').html(opt);
                if(getParam('typeTag')){
                    $('#typeTag').val(getParam('typeTag'))
                }
            }
        }
    })
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