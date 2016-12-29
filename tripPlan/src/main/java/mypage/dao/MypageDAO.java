package mypage.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class MypageDAO extends SqlSessionDaoSupport {

	// ����� �ĺ� : ��� = 0, Ȱ�� = 1, ���� = 2, ������ = 3
	public MemberInfo userIdentified(String m_email) {
		
		MemberInfo identified = getSqlSession().selectOne("member.identified", m_email);
		return identified;
	}
	
	public void verifySuccess(String m_email) {
		getSqlSession().update("member.verify", m_email);
		
	}
	// �ǽð� ���� ī��Ʈ
	public int realtimeCount(String m_email) {
		
		int check = getSqlSession().selectOne("member.realtimeCount",m_email);
		
		return check;
	}
	
}
