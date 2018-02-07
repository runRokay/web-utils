var login = {
    login: function () {
        $("#loginForm").ajaxSubmit(function (data) {
            data = JSON.parse(data);
            if (data.success) {
                window.location.href = "./index";
            } else {
                layer.msg(data.message, {icon: 2});
            }
        });
    },
    layerIndex: 0,
    register: function () {
        login.layerIndex = layer.open({
            type: 1,
            area: ['400px', '400px'],
            title: '注册',
            content: '<div class="well" id="device_register_div"></div>'
        });
        $("div#device_register_div").load('./register');
    },
    saveRegister: function () {
        var password = $("#password").val();
        var re_password = $("#re_password").val();
        if (password != re_password) {
            layer.msg("两次输入的密码不一致，请检查", {icon: 1});
            return;
        }
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
    }
}
