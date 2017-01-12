package mypage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class MypageDAO extends SqlSessionDaoSupport {

	// 사용자 식별 : 대기 = 0, 활동 = 1, 네이버 = 2, 정지 = 3, 관리자 = 4
	public MemberInfo userIdentified(String m_email) {
		
		MemberInfo identified = getSqlSession().selectOne("member.identified", m_email);
		return identified;
	}
	
	public void verifySuccess(String m_email) {
		int m_identified = getSqlSession().selectOne("member.getIdentified", m_email);
		if(m_identified==0) {
			getSqlSession().update("member.verify", m_email);
		}
	}
	// 실시간 쪽지 카운트
	public int realtimeCount(String m_email) {
		
		int check = getSqlSession().selectOne("member.realtimeCount",m_email);
		
		return check;
	}
	
	public List<String> finduser(String m_email) {
		List<String> resultList = getSqlSession().selectList("member.finduser", m_email);
		
		return resultList;
	}
	
	public List<String> findfollow(String m_email) {
		List<String> resultList = getSqlSession().selectList("member.findfollow", m_email);
		
		return resultList;
	}
	
	public void addfollow(String f_email, String m_email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("f_email", f_email);
		map.put("m_email", m_email);
		getSqlSession().insert("member.addfollow", map);
		
	}
	
	public void delfollow(String f_email, String m_email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("f_email", f_email);
		map.put("m_email", m_email);
		getSqlSession().delete("member.delfollow", map);
		
	}
	
	public int updateProfile(MemberInfo memberInfo) {
		getSqlSession().update("member.updateprofile", memberInfo);
		int check = 1;
		return check;
	}
	
}
