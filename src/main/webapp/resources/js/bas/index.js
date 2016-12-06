/**
 * Created by Administrator on 2016-11-24 0024.
 */

function login() {


    //表单提交
    $("#form_login").attr("action", "login.do");
    $("#form_login").submit();

    //ajax 提交方法
    /*var data = $("#form_login").serializeArray();
    $.ajax({
        type: "POST",
        url: "login.do",
        data: data,
        success: function () {
        }
    });*/
}
