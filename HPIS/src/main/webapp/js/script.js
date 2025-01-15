function checkLogin(){
  var username = document.getElementsByName("username");
  var password = document.getElementsByName("password");

  if(username[0].value=="" || password[0].value==""){
    alert("用户名和账号不能为空");
    return false;
  }else{
    return true;
  }
}

function check(){
  var name = document.getElementsByName("name");
  var age = document.getElementsByName("age");
  var sex = document.getElementsByName("sex");
  var account = document.getElementsByName("account");
  var password = document.getElementsByName("password");

  //判断姓名是否为空
  if(name[0].value==""){
    alert("用户名不能为空");
    return false;
  }

  //判断年龄是否为数组，其范围是0-150
  var ageNumber = parseInt(age[0].value);
  if(isNaN(ageNumber)){
    alert("年龄必须是数字!");
    return false;
  }else if(ageNumber<=15 || ageNumber>35){
    alert("年龄范围是15-35")
    return false;
  }

  //判断性别是否被选中
  var flag = false;
  for(var i = 0; i<sex.length; i++){
    s = sex[i];
    if(s.checked){
      flag = true;
    }
  }

  if(!flag){
    alert("性别还没选");
    return false;
  }

  //判断账号是否为空
  if(account[0].value==""){
    alert("账号不能为空");
    return false;
  }

  //判断密码是否为空
  if(password[0].value==""){
    alert("密码不能为空");
    return false;
  }

  return true;
}
function toggleReviews() {
    const reviews = document.getElementById('reviews');
    const button = document.querySelector('.toggle-button');

    if (reviews.style.display === 'none' || reviews.style.display === '') {
        reviews.style.display = 'block'; // 显示评价
        button.textContent = '隐藏评价'; // 修改按钮文本
    } else {
        reviews.style.display = 'none'; // 隐藏评价
        button.textContent = '显示评价'; // 修改按钮文本
    }
}
function showLoginType(type, element) {
                // 隐藏所有登录表单
                document.getElementById('accountLogin').style.display = 'none';
                document.getElementById('accountPassword').style.display = 'none';
                document.getElementById('smsLogin').style.display = 'none';
                document.getElementById('smsPassword').style.display = 'none';
    
                // 显示对应的登录表单
                if (type === 'account') {
                    document.getElementById('accountLogin').style.display = 'block';
                    document.getElementById('accountPassword').style.display = 'block';
                } else if (type === 'sms') {
                    document.getElementById('smsLogin').style.display = 'block';
                    document.getElementById('smsPassword').style.display = 'block';
                }
    
                // 更新选中状态
                const loginOptions = document.querySelectorAll('.headText span');
                loginOptions.forEach(option => {
                    option.classList.remove('active'); // 移除所有选中状态
                });
                element.classList.add('active'); // 设定当前元素为选中
            }

