package mypage.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class MypageDAO extends SqlSessionDaoSupport {

	// 사용자 식별 : 대기 = 0, 활동 = 1, 정지 = 2, 관리자 = 3
	public MemberInfo userIdentified(String m_email) {
		
		MemberInfo identified = getSqlSession().selectOne("member.identified", m_email);
		return identified;
	}
	
	public void verifySuccess(String m_email) {
		getSqlSession().update("member.verify", m_email);
		
	}
	// 실시간 쪽지 카운트
	public int realtimeCount(String m_email) {
		
		int check = getSqlSession().selectOne("member.realtimeCount",m_email);
		
		return check;
	}
	
}
