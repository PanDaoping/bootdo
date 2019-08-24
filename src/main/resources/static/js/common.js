$(function(){
    initPage();
    tableTitle();
    textareaNo();
})
/**
 * 初始化页面效果
 */
function initPage(){
    var height = parent.height;
    $(".mac").css("height",(parseInt(height)-120)+"px");
}

function leftmac(){
    $(".macul li:first").addClass("active");
    $(".macheade div").click(function(){
        $(".macheade div").removeClass("active");
        $(this).addClass("active");
        $("#eqStatus").val($(this).attr("data"));
        pageList();
    })
}

/**
 * 在表格所有td中添加title属性用于超长时悬浮显示内容
 */
function tableTitle(){
    $(".table tbody td").each(function(){
        if($(this).html().indexOf(">")<0){
            $(this).attr("title",$(this).html());
        }

    });
    $(".table tbody tr").unbind("click").bind("click",function(){

        if($(this).find(".input_cls").prop("checked")){
            $(this).find(".input_cls").prop("checked",false);
        }else{
            $(this).find(".input_cls").prop('checked', true);
        }
    });
    $("input[type='checkbox'], input[type='text']").click(function(e){
        e.stopPropagation();
    });
}
var isAllChecked=false;
function changeAll(){
    if(!isAllChecked){
        $(".table tbody .input_cls").each(function(){
            isAllChecked =true;
            $(this).prop("checked",true);
        });
    }else{
        $(".table tbody .input_cls").each(function(){
            $(this).prop("checked",false);
            isAllChecked=false;
        });
    }
}
/**
 * 为所有must必填项添加红*    class添加must类名
 *//*
function must(){
	$(".must").each(function(){
		$(this).after("<span style='color:#E84048;'>*<span>");
	});
}*/

/**
 * 检验textarea文字可输入长度  textarea必须有no属性为可输入最大长度
 */
function textareaNo(){
    $("textarea").each(function(){
        var no = $(this).attr("no")?$(this).attr("no"):'';

        if(no!=""){
            $(this).parent().after("<div class='text-right'>限　"+no+"字以内</span>")
        }
    })
    $("textarea").bind("input",function(){
        var no = $(this).attr("no")?$(this).attr("no"):'';
        var realno =  $(this).val().length;
        if(no!=""){
            $(this).parent().siblings(".text-right").html("限　"+(parseInt(no)-realno)+"字以内")
        }
    })
}

function mesAlert(title,content){
    $.dialog({title : title,content : content ,width : 300,height : 50,cancelVal : '确认',cancel : true,
        lock : true,min : false,max : false});
}

// function mesConfirm(title,content,ok){
//     $.dialog({title:title,content: content,width: 400,height: 40,
//         ok:ok,cancelVal: '取消',cancel: true,lock:true,min:false,max:false});
// }

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function Todate(num) { //Fri Oct 31 18:00:00 UTC+0800 2008   转换日期格式
    num = num + "";
    var date = "";
    var month = new Array();
    month["Jan"] = 1; month["Feb"] = 2; month["Mar"] = 3; month["Apr"] = 4; month["May"] = 5; month["Jun"] = 6;
    month["Jul"] = 7; month["Aug"] = 8; month["Sep"] = 9; month["Oct"] = 10; month["Nov"] = 11; month["Dec"] = 12;
    var week = new Array();
    week["Mon"] = "一"; week["Tue"] = "二"; week["Wed"] = "三"; week["Thu"] = "四"; week["Fri"] = "五"; week["Sat"] = "六"; week["Sun"] = "日";
    str = num.split(" ");
    date = str[5] + "-";
    var date2=month[str[1]]<10?'0'+month[str[1]]:month[str[1]]
    date = date +  date2+ "-" + str[2] ;
    return date;
}
function getParam(paramName) {    //获取路径参数
    paramValue = "", isFound = !1;
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0;
        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
    }
    return paramValue == "" && (paramValue = null), paramValue
}

function getParam2(text){
    var href=window.location.href.split('?')[1]
        href=href?href.split('&'):[]
    var tes={};
    for(var i in href){
        var h=href[i].split('=')
        tes[h[0]]=h[1]
    }
    if(tes[text]){
        return tes[text]
    }else{
        return ''
    }
}


function RndNum(n){   //产生随机数函数
    var rnd="";
    for(var i=0;i<n;i++)
        rnd+=Math.floor(Math.random()*10);
    return rnd;
}
function isNull(){     //判断表单是否为空
    var fal=true ;
    $('body').find('input[error],select[error],textarea[error]').each(function(){
        var errortext=$(this).attr('error');
            var value=$(this).val();
        if(!value){                                         //判断是否为空
            $(this).css('borderColor','red')
            layer.msg(errortext);
            fal=false
            return false
        }else{
            if($(this).attr('regular')){
                var regular= $(this).attr('regular')  //正则表达式
                if(regular.test($(this).val())){
                    $(this).css('borderColor','')
                }else{
                    $(this).css('borderColor','red')
                    layer.msg($(this).attr('regularText'));  //正则错误提示
                    fal=false
                    return false
                }
            }else{
                $(this).css('borderColor','')
            }
        }
    })

    return  fal
}
//表单失焦事件
$('body').delegate('input[error],select[error],textarea[error]','blur',function(){

        var value=$(this).val();


    if(!value){
        $(this).css('borderColor','red')
    }else{
        $(this).css('borderColor','');
    }

    if($(this).attr('lay-key')){
        $(this).css('borderColor','')
    }

})

function uploadSuccess(file,serverData){   //上传回调
//	var  filePath = serverData;

    if(serverData.indexOf("fileName")>=0){
        var json = eval('(' + serverData + ')');
        var filePath="",fileName="",fileType="";
        if($('#filePath').val()==""){
            filePath=json.filePath;
            fileName=json.fileName;
        //    fileType=json.fileType;
            fileType=json.extension;
        }else{
            filePath=$('#filePath').val()+","+json.filePath;
            fileName=$('#fileName').val()+","+json.fileName;
           // fileType=$('#fileType').val()+","+json.fileType;
            fileType=$('#fileType').val()+","+json.extension;
        }
        $('#filePath').val(filePath);
        $('#fileName').val(fileName);
        $('#fileType').val(fileType);
        $('#annexNum').val(parseInt($('#annexNum').val())+1);
    }
    setIframeHeight($('#docUpload')[0]) //iframe 高度自适应
}

$(document).keydown(function(event){
var target=event.target;
if(target.nodeName=='TEXTAREA'){

}else{
    if(event.keyCode == 13){
        return false;
    }
}
　});
$('body').delegate('button,a','click',function(e){
    this.blur();
})

$('body').delegate('input[type="number"]','input',function(e){
    var value=parseFloat($(this).val())
    var max=parseFloat($(this).attr('max'))
    if(max && value){
            if(value>max){
                $(this).val(max)
            }
    }
})




jQuery.validator.addMethod("isIdCardNo", function(value, element) {
    return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
}, "<i class=\"fa fa-times-circle\"></i> 请正确输入您的身份证号码");
// 手机号码验证
jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "<i class=\"fa fa-times-circle\"></i> 请正确填写您的手机号码");
jQuery.validator.addMethod("isTel", function(value, element) {
    var length = value.length;
    var tel = /^\d{3,4}-?\d{7,9}$/;
    return this.optional(element) || (tel.test(value));
}, "<i class=\"fa fa-times-circle\"></i> 请正确填写您的电话号码,格式为:XXXX(3-4位)-XXXXXXXX(7-9位)");
jQuery.validator.addMethod("isSpecial", function(value, element) {
    var mobile = /[@\$%\^&\*?,#;？]+/g;
    return this.optional(element) || ( !mobile.test(value));
}, "<i class=\"fa fa-times-circle\"></i> 不允许输入特殊字符");
jQuery.validator.addMethod("isSpecial01", function(value, element) {
    var mobile = /[@\$%\^&\*?,#;？]+/g;
    return this.optional(element) || ( !mobile.test(value));
}, "<i class=\"fa fa-times-circle\"></i> 不允许输入特殊字符");
jQuery.validator.addMethod("isPassword", function(value, element) {
	return this.optional(element) || /^.{6,20}$/.test(value);
	}, "<i class=\"fa fa-times-circle\"></i> 密码格式,长度在6-20字符之间");
jQuery.validator.addMethod("wordDigitCheck", function(value, element) {
    var str = /^\w+$/;
    return this.optional(element) || (str.test(value));
},"<i class=\"fa fa-times-circle\"></i> 只能包括英文字母、数字和下划线");
jQuery.validator.addMethod("idCheck", function(value, element) {
return this.optional(element) || /^[a-zA-Z]\w{0,19}$/.test(value);
}, "<i class=\"fa fa-times-circle\"></i> 以字母开头，长度在1-20字符之间，只能包含英文、数字和下划线。");
jQuery.validator.addMethod("nameCheck", function(value, element) {
    //return this.optional(element) || /^[\u0391-\uFFE5w]+$/.test(value);  //只能输入汉字
    //var str = /^[\u0391-\uFFE5\w]+$/;
    var str = /^[\w\u4e00-\u9fa5]{1,30}$/;
    return this.optional(element) || (str.test(value));
},"<i class=\"fa fa-times-circle\"></i> 长度在1-30字符之间，只能包含中文、英文、数字和下划线");
jQuery.validator.addMethod("chineseCheck", function(value, element) {
    //return this.optional(element) || /^[\u0391-\uFFE5w]+$/.test(value);  //只能输入汉字
    //var str = /^[\u0391-\uFFE5\w]+$/;
    var str =/(^[\u4e00-\u9fa5a-zA-Z]+$)|(^[\u4e00-\u9fa5a-zA-Z][\u4e00-\u9fa5a-zA-Z\w]+$)/;
    return this.optional(element) || (str.test(value));
},"<i class=\"fa fa-times-circle\"></i> 以汉字或字母开头,可使用汉字、字母、数字、下划线");

//字符最大长度验证（一个中文字符长度为2）
var param01='';
jQuery.validator.addMethod("stringMaxLength", function(value, element, param) {
    var length = value.length;
    param01=param;
    for(var i = 0; i < value.length; i++) {
        if(value.charCodeAt(i) > 127) {
            length++;
        }
    }
    return this.optional(element) || (length <= param);
},"<i class=\"fa fa-times-circle\"></i>输入的字符串不能大于"+param01);

var idCardNoUtil = {
    provinceAndCitys: {11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",
        31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",
        45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",
        65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"},
    powers: ["7","9","10","5","8","4","2","1","6","3","7","9","10","5","8","4","2"],
    parityBit: ["1","0","X","9","8","7","6","5","4","3","2"],
    genders: {male:"男",female:"女"},
    checkAddressCode: function(addressCode){
        var check = /^[1-9]\d{5}$/.test(addressCode);
        if(!check) return false;
        if(idCardNoUtil.provinceAndCitys[parseInt(addressCode.substring(0,2))]){
            return true;
        }else{
            return false;
        }
    },
    checkBirthDayCode: function(birDayCode){
        var check = /^[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))$/.test(birDayCode);
        if(!check) return false;
        var yyyy = parseInt(birDayCode.substring(0,4),10);
        var mm = parseInt(birDayCode.substring(4,6),10);
        var dd = parseInt(birDayCode.substring(6),10);
        var xdata = new Date(yyyy,mm-1,dd);
        if(xdata > new Date()){
            return false;//生日不能大于当前日期
        }else if ( ( xdata.getFullYear() == yyyy ) && ( xdata.getMonth () == mm - 1 ) && ( xdata.getDate() == dd ) ){
            return true;
        }else{
            return false;
        }
    },
    getParityBit: function(idCardNo){
        var id17 = idCardNo.substring(0,17);

        var power = 0;
        for(var i=0;i<17;i++){
            power += parseInt(id17.charAt(i),10) * parseInt(idCardNoUtil.powers[i]);
        }

        var mod = power % 11;
        return idCardNoUtil.parityBit[mod];
    },
    checkParityBit: function(idCardNo){
        var parityBit = idCardNo.charAt(17).toUpperCase();
        if(idCardNoUtil.getParityBit(idCardNo) == parityBit){
            return true;
        }else{
            return false;
        }
    },
    checkIdCardNo: function(idCardNo){
//15位和18位身份证号码的基本校验
        var check = /^\d{15}|(\d{17}(\d|x|X))$/.test(idCardNo);
        if(!check) return false;
//判断长度为15位或18位
        if(idCardNo.length==15){
            return idCardNoUtil.check15IdCardNo(idCardNo);
        }else if(idCardNo.length==18){
            return idCardNoUtil.check18IdCardNo(idCardNo);
        }else{
            return false;
        }
    },

//校验15位的身份证号码
    check15IdCardNo: function(idCardNo){
//15位身份证号码的基本校验
        var check = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}$/.test(idCardNo);
        if(!check) return false;
//校验地址码
        var addressCode = idCardNo.substring(0,6);
        check = idCardNoUtil.checkAddressCode(addressCode);
        if(!check) return false;
        var birDayCode = '19' + idCardNo.substring(6,12);
//校验日期码
        return idCardNoUtil.checkBirthDayCode(birDayCode);
    },

//校验18位的身份证号码
    check18IdCardNo: function(idCardNo){
//18位身份证号码的基本格式校验
        var check = /^[1-9]\d{5}[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}(\d|x|X)$/.test(idCardNo);
        if(!check) return false;
//校验地址码
        var addressCode = idCardNo.substring(0,6);
        check = idCardNoUtil.checkAddressCode(addressCode);
        if(!check) return false;
//校验日期码
        var birDayCode = idCardNo.substring(6,14);
        check = idCardNoUtil.checkBirthDayCode(birDayCode);
        if(!check) return false;
//验证校检码
        return idCardNoUtil.checkParityBit(idCardNo);
    },

    formateDateCN: function(day){
        var yyyy =day.substring(0,4);
        var mm = day.substring(4,6);
        var dd = day.substring(6);
        return yyyy + '-' + mm +'-' + dd;
    },

//获取信息
    getIdCardInfo: function(idCardNo){
        var idCardInfo = {
            gender:"", //性别
            birthday:"" // 出生日期(yyyy-mm-dd)
        };
        if(idCardNo.length==15){
            var aday = '19' + idCardNo.substring(6,12);
            idCardInfo.birthday=idCardNoUtil.formateDateCN(aday);
            if(parseInt(idCardNo.charAt(14))%2==0){
                idCardInfo.gender=idCardNoUtil.genders.female;
            }else{
                idCardInfo.gender=idCardNoUtil.genders.male;
            }
        }else if(idCardNo.length==18){
            var aday = idCardNo.substring(6,14);
            idCardInfo.birthday=idCardNoUtil.formateDateCN(aday);
            if(parseInt(idCardNo.charAt(16))%2==0){
                idCardInfo.gender=idCardNoUtil.genders.female;
            }else{
                idCardInfo.gender=idCardNoUtil.genders.male;
            }

        }
        return idCardInfo;
    },
    getId15:function(idCardNo){
        if(idCardNo.length==15){
            return idCardNo;
        }else if(idCardNo.length==18){
            return idCardNo.substring(0,6) + idCardNo.substring(8,17);
        }else{
            return null;
        }
    },
    getId18: function(idCardNo){
        if(idCardNo.length==15){
            var id17 = idCardNo.substring(0,6) + '19' + idCardNo.substring(6);
            var parityBit = idCardNoUtil.getParityBit(id17);
            return id17 + parityBit;
        }else if(idCardNo.length==18){
            return idCardNo;
        }else{
            return null;
        }
    }
};
//验证护照是否正确
function checknumber(number){
    var str=number;
//在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
    var Expression=/(P\d{7})|(G\d{8})/;
    var objExp=new RegExp(Expression);
    if(objExp.test(str)==true){
        return true;
    }else{
        return false;
    }
};

function getNowFormatDate() {  //获取今天的日期 年月日
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
function CurentTime(){    //年月日时分秒
    var now = new Date();
    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日
    var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分
    var ss = now.getSeconds();           //秒
    var clock = year + "-";
    if(month < 10)
        clock += "0";
    clock += month + "-";
    if(day < 10)
        clock += "0";
    clock += day + " ";
    if(hh < 10)
        clock += "0";
    clock += hh + ":";
    if (mm < 10) clock += '0';
    clock += mm + ":";
    if (ss < 10) clock += '0';
    clock += ss;
    return(clock);
}

/********/
function setIframeHeight(obj){   //自适应 iframe 的高度
    try{
        var iframe = obj
        if(iframe.attachEvent){
            iframe.attachEvent("onload", function(){
                iframe.height =  iframe.contentWindow.document.documentElement.scrollHeight;
            });
            return;
        }else{
                $(iframe).height( iframe.contentDocument.body.scrollHeight)
            return;
        }
    }catch(e){
        throw new Error('setIframeHeight Error');
    }
}
function upImagesFancybox(str){ //图片预览
    $.fancybox.open(str);
}