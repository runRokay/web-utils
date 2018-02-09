$(function () {
    $("#loginForm").validate({
        rules: {
            userName: "required",
            password: {
                required: true,
                minlength: 6
            },
        },
        messages: {
            userName: "请输入用户名",
            password: {
                required: "请输入密码",
                minlength: "密码长度不能小于 6 个字母"
            },
        }
    });
    $("#saveDeviceForm").ajaxSubmit(function (data) {
        data = JSON.parse(data);
        if (data.success) {
            layer.msg(data.message, {icon: 1}, function () {
                window.location.href = "./index";
            });
        } else {
            layer.msg(data.message, {icon: 2});
        }
    });
})
