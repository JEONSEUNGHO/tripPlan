package mypage.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import member.model.MemberInfo;

public class PasswordDAO extends SqlSessionDaoSupport {

	public int updatePass(MemberInfo memberInfo) {
		
		// ��й�ȣ ��ȣȭ ó��
		String beforeEncryp = memberInfo.getM_pass1();
		
		// �� ��й�ȣ�� BCrypt �˰��� �ؽ� ����, passwordHashed ������ ���� �����ͺ��̽��� ����� 60����Ʈ�� ���ڿ��� �ȴ�.
		String afterEncryp = BCrypt.hashpw(beforeEncryp, BCrypt.gensalt(10));

		//  ��ȣȭ�� ��й�ȣ�� DB�� �� ������ ���� 
		memberInfo.setM_pass1(afterEncryp);
		
		int check = getSqlSession().update("member.updatePass", memberInfo);
		// DB���� �ҷ��� ��й�ȣ�� �Է¹��� ��й�ȣ�� ��
		if(check == 1) {
			return check;
		} 
		return check;
}

	public int getPass(MemberInfo memberInfo, String m_email) {
		String passwdFromDB = getSqlSession().selectOne("member.getPass", m_email);
		int flag = -1;
		// DB���� �ҷ��� ��й�ȣ�� �Է¹��� ��й�ȣ�� ��
		boolean passwdMatchResult = BCrypt.checkpw(memberInfo.getM_pass(), passwdFromDB);
		if(passwdMatchResult == true) {
			flag = 1;
			return flag;
		} 
		return flag;

	}

}
