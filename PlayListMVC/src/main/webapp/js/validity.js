$(function( ) {
// JSON 형식으로 유효성 검사의 규칙을 설정한다.
    $("#signupForm").validate({ // 검사할 필드와 검사 항목을
        rules : {
// 필수 입력을 설정한다.
            name : "required", age : {
// 필수 여부를 설정한다.
                required : true,
// 숫자 입력을 설정한다.
                digits : true },
            id : {
                required : true,
// 최소길이를 설정한다.
                minlength : 4 },
            password : { required : true, minlength : 4,
// 최대길이를 설정한다.
                maxlength : 8 },
            pwdre : {
                required : true, equalTo : "#password"
            },
            email : {
                required : true,
                email : true },
            weburl : { url : true
            },
            topic : {
                required : "#newsletter:checked",
                minlength : 2 },
            agree : "required" },
        // 검사를 충족하지 못하면 표시될 메시지를
        messages : {
            name : "이름을 입력하세요.", age : {
                required : "나이를 입력하세요.",
                digits : "숫자로만 입력하세요." },
            id : {
                required : "아이디를 입력하세요.", minlength : "최소 {0} 글자입니다."
            },
            password : {
                required : "비밀번호를 입력하세요.", minlength : "최소 {0} 글자입니다.", maxlength : "최대 {0} 글자입니다."
            },
            pwdre : {
                required : "비밀번호를 확인하세요.",
                equalTo : "비밀번호가 틀립니다." },

            email : {
                required : "이메일을 입력하세요.", email : "이메일이 형식을 확인하세요."
            },
            weburl : {
                url : "올바른 인터넷 주소 형식이 아닙니다." },
            topic : {
                required : "뉴스레터 가입 시 관심 분야 선택은 필수입니다.", minlength : "최소 {0} 개 이상 체크해 주세요."
            },
            agree : "약관 동의에 체크해 주세요." }
    });
});