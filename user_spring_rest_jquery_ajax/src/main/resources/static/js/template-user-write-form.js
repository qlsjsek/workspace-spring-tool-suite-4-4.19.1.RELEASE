/**
 * 
 */
export function user_write_form(responseJsonObject = {}) {
	let htmlTemplate =
		`<table width="0" border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
				<!--contents--> <br>
				<table style="padding-left: 10px" border="0" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr>
							<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 -
									회원 가입</b></td>
						</tr>
					</tbody>
				</table> 
				<!-- write Form  -->
				<form name="f" id="user_write_form" method="post">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tbody>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">사용자
									아이디</td>
								<td width="490" bgcolor="ffffff" style="padding-left: 10px"
									align="left"><input type="text" style="width: 150px"
									name="userId" id="userId" value="{{data.userId}}">&nbsp;&nbsp;<font color="red">{{message}}</font>
								</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">비밀번호</td>
								<td width="490" bgcolor="ffffff" style="padding-left: 10px"
									align="left"><input type="password" style="width: 150px"
									name="password" id="password" value="{{data.password}}"></td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">비밀번호
									확인</td>
								<td width="490" bgcolor="ffffff" style="padding-left: 10px"
									align="left"><input type="password" style="width: 150px"
									name="password2" value="{{data.password}}"></td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
								<td width="490" bgcolor="ffffff" style="padding-left: 10px"
									align="left"><input type="text" style="width: 150px"
									name="name" value="{{data.name}}"></td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">이메일
									주소</td>
								<td width="490" bgcolor="ffffff" style="padding-left: 10px"
									align="left"><input type="text" style="width: 150px"
									name="email" value="{{data.email}}"></td>
							</tr>
						</tbody>
					</table>
				</form>
			
				<br>

				<table border="0" cellpadding="0" cellspacing="1">
					<tbody>
						<tr>
							<td align="center">
							<input type="button" data-navigate="/user_write_action"  id="btn_user_write_action" value="회원 가입"> &nbsp;</td>
						</tr>
					</tbody>
				</table>

			</td>
		</tr>
	</tbody>
	</table>
	`;
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}