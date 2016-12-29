package member.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import member.model.MemberInfo;

public class MemberDAO extends SqlSessionDaoSupport {

	public int insertFile(MemberInfo memberInfo) {
		
		// ��й�ȣ ��ȣȭ ó��
		String beforeEncryp = memberInfo.getM_pass();
		
		// �� ��й�ȣ�� BCrypt �˰��� �ؽ� ����, passwordHashed ������ ���� �����ͺ��̽��� ����� 60����Ʈ�� ���ڿ��� �ȴ�.
		String afterEncryp = BCrypt.hashpw(beforeEncryp, BCrypt.gensalt(10));

		//  ��ȣȭ�� ��й�ȣ�� DB�� �� ������ ���� 
		memberInfo.setM_pass(afterEncryp);
		
		int check = getSqlSession().insert("member.regist", memberInfo);
		return check;
	}
	
	public String duplicationCheck(MemberInfo memberInfo) {
		
		String check = getSqlSession().selectOne("member.duplicheck", memberInfo);
		return check;
	}
	
	public void updatePW(MemberInfo memberInfo) {
		
		// ��й�ȣ ��ȣȭ ó��
		String beforeEncryp = memberInfo.getTempPW();
		
		// �� ��й�ȣ�� BCrypt �˰��� �ؽ� ����, passwordHashed ������ ���� �����ͺ��̽��� ����� 60����Ʈ�� ���ڿ��� �ȴ�.
		String afterEncryp = BCrypt.hashpw(beforeEncryp, BCrypt.gensalt(10));

		//  ��ȣȭ�� ��й�ȣ�� DB�� �� ������ ���� 
		memberInfo.setTempPW(afterEncryp);
		
		getSqlSession().update("member.updatepw", memberInfo);
	}
	
	public int realTimeIdchk(String m_email) {

		String check = getSqlSession().selectOne("member.realtimeidchk", m_email);
		if(check==null) {
			check="";
			// ���԰���
			return 0;
		}
		// ���ԺҰ�
		return 1;
	}
	
	
}
