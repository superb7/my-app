package com.sp.app.admin.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.sp.app.admin.domain.dto.MemberManageDto;
import com.sp.app.admin.mapper.MemberManageMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberManageServiceImpl implements MemberManageService {
	private final MemberManageMapper mapper;
	
	@Override
	public int dataCount(Map<String, Object> map) {
		int result = 0;
		
		try {
			result = mapper.dataCount(map);
		} catch (Exception e) {
			log.info("dataCount : ", e);
		}
		
		return result;
	}

	@Override
	public List<MemberManageDto> listMember(Map<String, Object> map) {
		List<MemberManageDto> list = null;
		
		try {
			list = mapper.listMember(map);
		} catch (Exception e) {
			log.info("listMember : ", e);
		}
		
		return list;
	}

	@Override
	public MemberManageDto findById(Long member_id) {
		MemberManageDto dto = null;

		try {
			// 객체 = Objects.requireNonNull(객체)
			//  : 파라미터로 입력된 값이 null 이면 NullPointerException를 발생하고,
			//    그렇지 않다면 입력값을 그대로 반환
			dto = Objects.requireNonNull(mapper.findById(member_id));
			
		} catch (NullPointerException e) {
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (Exception e) {
			log.info("findById : ", e);
		}

		return dto;
	}

	@Override
	public void updateMember(Map<String, Object> map) throws Exception {
		try {
			mapper.updateMember1(map);
			mapper.updateMember2(map);
		} catch (Exception e) {
			log.info("updateMember : ", e);
			
			throw e;
		}
	}
	
	@Override
	public void updateMemberLevel(Map<String, Object> map) throws Exception {
		try {
			mapper.updateMemberLevel(map);
		} catch (Exception e) {
			log.info("updateMemberLevel : ", e);
			
			throw e;
		}
	}

	@Override
	public void updateMemberEnabled(Map<String, Object> map) throws Exception {
		try {
			mapper.updateMemberEnabled(map);
		} catch (Exception e) {
			log.info("updateMemberEnabled : ", e);
			
			throw e;
		}
	}

	@Override
	public void updateFailureCountReset(Long member_id) throws Exception {
		try {
			mapper.updateFailureCountReset(member_id);
		} catch (Exception e) {
			log.info("updateFailureCountReset : ", e);
			
			throw e;
		}
	}

	@Override
	public void insertMemberStatus(MemberManageDto dto) throws Exception {
		try {
			mapper.insertMemberStatus(dto);
		} catch (Exception e) {
			log.info("insertMemberStatus : ", e);
						
			throw e;
		}
	}

	@Override
	public List<MemberManageDto> listMemberStatus(Long member_id) {
		List<MemberManageDto> list = null;
		
		try {
			list = mapper.listMemberStatus(member_id);
		} catch (Exception e) {
			log.info("listMemberStatus : ", e);
		}
		
		return list;
	}

	@Override
	public MemberManageDto findByStatus(Long member_id) {
		MemberManageDto dto = null;

		try {
			dto = mapper.findByStatus(member_id);
		} catch (Exception e) {
			log.info("findByStatus : ", e);
		}

		return dto;
	}

	@Override
	public List<Map<String, Object>> listAgeSection() {
		List<Map<String, Object>> list = null;
		
		try {
			list = mapper.listAgeSection();
		} catch (Exception e) {
			log.info("listAgeSection : ", e);
		}
		
		return list;
	}
}
