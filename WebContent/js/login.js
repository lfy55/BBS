$(document).ready(function(){
    //点击提交按钮时，从服务端获取数据，然后在客户端显示

    $("#btn").click(function(){
    	alert("come click!!");
        // 序列化表单的值
        var params=$("form").serialize();
        $.ajax({
            url: "user/jqueryAction",
            // 数据发送方式
            type: "post",
            // 接受数据格式
            dataType : "json",
            // 要传递的数据
            data : params,
            // 回调函数，接受服务器端返回给客户端的值，即result值
            success : function show(data){
                //测试result是否从服务器端返回给客户端
                //alert(result);
                //解析json对象
            	alert("come show!!");
                var json = eval("("+data+")");
                var obj = "欢迎 "+json.name+"  登陆 ";
                $("#resultDiv").html(obj);
            },error:function(data){alert('出错。。\n'+data.responseText);}
        });
    });
});
 
