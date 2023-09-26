/**
 * 
 */
export function guest_modify_form(responseJsonObject) {
	let htmlTemplate =
		`
	<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td><br>
				<table style="padding-left: 10px" border="0" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr>
							<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
									방명록 수정</b></td>
						</tr>
					</tbody>
				</table> <!-- modify Form  -->
				{{#with data.[0] }}
				<form id="f" name="f" method="post">
					<input type="hidden" name="guest_no" value="{{guest_no}}">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tbody>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">번호</td>
								<td align="left" width="490" bgcolor="ffffff"
									style="padding-left: 10px">{{guest_no}}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
								<td align="left" width="490" bgcolor="ffffff"
									style="padding-left: 10px"><input type="text"
									style="width: 150" name="guest_name" value="{{guest_name}}"></td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">홈페이지</td>
								<td align="left" width="490" bgcolor="ffffff"
									style="padding-left: 10px"><input type="text"
									style="width: 150" name="guest_homepage" value="{{guest_homepage}}"></td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">이메일</td>
								<td align="left" width="490" bgcolor="ffffff"
									style="padding-left: 10px"><input type="text"
									style="width: 240" name="guest_email" value="{{guest_email}}"></td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">제목</td>
								<td align="left" width="490" bgcolor="ffffff"
									style="padding-left: 10px"><input type="text"
									style="width: 240" name="guest_title" value="{{guest_title}}"></td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">내용</td>
								<td align="left" width="490" bgcolor="ffffff"
									style="padding-left: 10px"><textarea wrap="soft"
										style="width: 240px" rows="10" name="guest_content">{{guest_content}}</textarea>

								</td>
							</tr>
						</tbody>
					</table>
				</form>
				{{/with}}
				<table width="590" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td align="center"><input type="button" data-navigate="/guest_modify_action/{{data.[0].guest_no}}" value="수정"
								id="btn_guest_modify_action"> &nbsp; <input
								id="btn_guest_list" type="button" data-navigate="/guest_list" value="목록"></td>
						</tr>
					</tbody>
				</table></td>
		</tr>
	</tbody>
	</table>
	`;
	let bindTemplate=Handlebars.compile(htmlTemplate);
	let resultTemplate=bindTemplate(responseJsonObject);
	return resultTemplate;
}