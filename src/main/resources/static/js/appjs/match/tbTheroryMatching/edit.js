$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
    var arrayMount = [];
    $('#parts .item_list .ItemOption').each(function () {
        var mtName = $(this).find('.mtName').val();
        var mtSpec = $(this).find('.mtSpec').val();
        var supplierName = $(this).find('.supplierName').val();
        var waterRate = $(this).find('.waterRate').val();
        var produce = $(this).find('.produce').val();
        var dosage = $(this).find('.dosage').val();
        var remark = $(this).find('.remark').val();
        arrayMount.push({'mtName': mtName, 'mtSpec': mtSpec,'supplierName':supplierName,'waterRate':waterRate,'produce':produce,'dosage':dosage,'remark':remark})
    });

	$.ajax({
		cache : true,
		type : "POST",
		url : "/match/tbTheroryMatching/update",
		data : $('#signupForm').serialize()+"&arrayMount="+JSON.stringify(arrayMount),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				// parent.reLoad();
				// var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				// parent.layer.close(index);
                window.location.href = "/match/tbTheroryMatching"
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
				required : icon + "请输入名字"
			}
		}
	})
}

$('#parts').delegate('.add_btn', 'click', function () {
    $('#parts .item_list').append($('#parts .item_list_hide').html())
})

$('#parts').delegate('.remove_btn', 'click', function () {
    $(this).closest('li').remove()
})