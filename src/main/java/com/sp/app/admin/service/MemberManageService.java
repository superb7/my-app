package com.sp.app.admin.service;

import java.util.List;
import java.util.Map;

import com.sp.app.admin.domain.dto.MemberManageDto;

public interface MemberManageService {
	public int dataCount(Map<String, Object> map);
	public List<MemberManageDto> listMember(Map<String, Object> map);
	
	public MemberManageDto findById(Long member_id);
	
	public void updateMember(Map<String, Object> map) throws Exception;
	public void updateMemberLevel(Map<String, Object> map) throws Exception;
	public void updateMemberEnabled(Map<String, Object> map) throws Exception;
	public void updateFailureCountReset(Long member_id) throws Exception;
	
	public void insertMemberStatus(MemberManageDto dto) throws Exception;
	public List<MemberManageDto> listMemberStatus(Long member_id);
	public MemberManageDto findByStatus(Long member_id);
	
	public List<Map<String, Object>> listAgeSection();
}
