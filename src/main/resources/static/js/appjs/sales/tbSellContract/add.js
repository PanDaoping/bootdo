$(function() {
	validateRule();
    time();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    var arrayMount = [];
    $('#parts .item_list .ItemOption').each(function () {
        var constructionPart = $(this).find('.constructionPart').val();
        var concreteStrengthGrade = $(this).find('.concreteStrengthGrade').val();
        var concreteSlump = $(this).find('.concreteSlump').val();
        var concretePlanAmount = $(this).find('.concretePlanAmount').val();
        var oncreteActualAmount = $(this).find('.oncreteActualAmount').val();
        arrayMount.push({'constructionPart': constructionPart, 'concreteStrengthGrade': concreteStrengthGrade,'concreteSlump':concreteSlump,'concretePlanAmount':concretePlanAmount,'oncreteActualAmount':oncreteActualAmount})
    });
    var filePath = "", fileName = "", fileType = "";
    $("#docUpload").contents().find(".progressImg").each(function () {
        filePath += "," + $(this).attr("data");
        fileName += "," + $(this).attr("data1");
        fileType += "," + $(this).attr("data2");
    })

    filePath=filePath.indexOf(",") >= 0 ? filePath.substring(1) : filePath;
    fileName=fileName.indexOf(",") >= 0 ? fileName.substring(1) : fileName;
    fileType=fileType.indexOf(",") >= 0 ? fileType.substring(1) : fileType;
    $('#annexNum').val($("#docUpload").contents().find(".progressImg").length);
    var ajaxData = "";
    ajaxData = 'filePath=' + filePath + '&fileName=' + fileName + '&fileType=' + fileType ;
		$.ajax({
		cache : true,
		type : "POST",
		url : "/sales/tbSellContract/save",
		data : $('#signupForm').serialize()+"&arrayMount="+JSON.stringify(arrayMount)+"&"+ajaxData,// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
//				parent.reLoad();
//				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
//				parent.layer.close(index);
                window.location.href = "/sales/tbSellContract"

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

$('#parts').delegate('.add_btn', 'click', function () {
	$('#parts .item_list').append($('#parts .item_list_hide').html())
})

$('#parts').delegate('.remove_btn', 'click', function () {
        $(this).closest('li').remove()
})

function time(){
    laydate.render({
        elem: '#contractStartDate'
        ,calendar: true
    });
    laydate.render({
        elem: '#contractOverDate'
        ,calendar: true
    });


}

function uploadSuccess(file,serverData){
    if(serverData.indexOf("fileName")>=0){
        var json = eval('(' + serverData + ')');
        var filePath="",fileName="",fileType="";
        if($('#filePath').val()==""){
            filePath=json.filePath;
            fileName=json.fileName;
            fileType=json.fileType;
        }else{
            filePath=$('#filePath').val()+","+json.filePath;
            fileName=$('#fileName').val()+","+json.fileName;
            fileType=$('#fileType').val()+","+json.fileType;
        }
        $('#filePath').val(filePath);
        $('#fileName').val(fileName);
        $('#fileType').val(fileType);
        $('#annexNum').val(parseInt($('#annexNum').val())+1);
    }

}