$(function(){
    $.ajax({
        type:"post",
        url:"/user/userinfo",
        data:{},
        success:function(data){
            $(".user_head_img").attr("src",data.headImage);
            $(".user_name").html(data.realName);
        }
    });
});