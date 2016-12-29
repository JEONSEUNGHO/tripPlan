package mypage.dao;

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
	
}
