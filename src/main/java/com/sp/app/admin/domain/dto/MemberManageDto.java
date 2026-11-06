package com.sp.app.admin.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberManageDto {
	private long member_id;
	private String login_id;
	private String password;
	private String sns_provider;
	private String sns_id;
	private int userLevel;
	private int enabled;
	private String created_at;
	private String update_at;
	private String last_login;
	private int failure_cnt;
	private String name;
	private String birth;
	private String email;
	private int receive_email;
	private String tel;
	private int age;
	private String profile_photo;
	private String zip;
	private String addr1;
	private String addr2;
	private String ipAddr;
	
	private long num;
	private int status_code;
	private String memo;
	private long register_id;
	private String login_register;
	private String registerName;
	private String reg_date;
}
