/**
 * 
 */
export function guest_list(responseJsonObject={}) {
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
										리스트</b></td>
							</tr>
						</tbody>
					</table>
					<form name="f" method="post">
	
						<table border="0" cellpadding="0" cellspacing="1" width="590"
							bgcolor="BBBBBB">
							<tbody>
								<tr>
									<td width="50" align="center" bgcolor="E6ECDE" height="22">번호</td>
									<td width="300" align="center" bgcolor="E6ECDE">제목</td>
									<td width="120" align="center" bgcolor="E6ECDE">이름</td>
									<td width="120" align="center" bgcolor="E6ECDE">날짜</td>
								</tr>
								{{#each data}}
								<!-- guest start -->
								<tr class="guest_item">
									<td width="50" align="center" bgcolor="ffffff" height="20">{{guest_no}}</td>
									<td width="300" bgcolor="ffffff" style="padding-left: 10">
										<a href="#/guest_view/{{guest_no}}"  class="user guest_item_a">{{guest_title}}
									</a>
									</td>
									<td width="120" align="center" bgcolor="ffffff">{{guest_name}}</td>
									<td width="120" align="center" bgcolor="ffffff">{{substring guest_date 0 10}}</td>
								</tr>
								<!-- guest end -->
							   {{/each}}
							</tbody>
						</table>
					</form> <!-- button -->
					<table border="0" cellpadding="0" cellspacing="1" width="590">
						<tbody>
							<tr>
								<td align="right"><input type="button" data-navigate="/guest_write_form" id="btn_guest_write_form" value="방명록 쓰기"></td>
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