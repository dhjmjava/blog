//登陆框
function login1() {
    $.dialog({ id: 'login', title: "用户登录", closeTitle: "", min: false, max: false, lock:true, width: "450px", height: "305px", content: 'url:login.aspx' });
}
//登陆框
function login2() {
    $.dialog({ id: 'login', title: "用户登录", closeTitle: "", min: false, max: false, lock: true, width: "450px", height: "305px", content: 'url:../login.aspx' });
}
//登陆框 带gourl
function login3(gourl) {
    $.dialog({ id: 'login', title: "用户登录", closeTitle: "", min: false, max: false, lock: true, width: "450px", height: "305px", content: 'url:login.aspx?gourl=' + gourl });
}
//登陆框 带gourl
function login4(gourl) {
    $.dialog({ id: 'login', title: "用户登录", closeTitle: "", min: false, max: false, lock: true, width: "450px", height: "305px", content: 'url:../../login.aspx?gourl=' + gourl });
}