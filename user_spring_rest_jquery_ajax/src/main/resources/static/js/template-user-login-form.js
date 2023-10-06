/**
 * 
 */
export function user_login_form(responseJsonObject = {}) {
	let htmlTemplate =
		`<table border=0 cellpadding=0 cellspacing=0>
		<tr>
		<td><br />
			<table style="padding-left: 10px" border=0 cellpadding=0
				cellspacing=0>
				<tr>
					<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 -
							로그인</b></td>
				</tr>
			</table> <!-- login Form  -->
			<form name="f" id="user_login_form" method="post">
				<table border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
					<tr>
						<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
							아이디</td>
						<td width=490 align="left" bgcolor="ffffff"
							style="padding-left: 10px"><input type="text"
							style="width: 150" name="userId" value="{{data.userId}}">&nbsp;&nbsp;<font
							color="red">{{#ifCond status '===' 5000}}{{message}}{{/ifCond}} </font></td>
					</tr>
					<tr>
						<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
						<td width=490 align="left" bgcolor="ffffff"
							style="padding-left: 10px"><input type="password"
							style="width: 150" name="password" value="{{data.password}}">&nbsp;&nbsp;<font
							color="red">{{#ifCond status '===' 5100}}{{message}}{{/ifCond}}</font></td>
					</tr>
				</table>
			</form> <br />
			<table border="0" cellpadding="0" cellspacing="1">
				<tr>
					<td align=center><input  data-navigate="/user_login_action"  type="button" value="로그인" id="btn_user_login_action"> &nbsp; <input type="button"
						value="회원가입폼" data-navigate="/user_write_form" id="btn_user_write_form"></td>
				</tr>
			</table></td>
	</tr>
	</table>
	`;
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}
