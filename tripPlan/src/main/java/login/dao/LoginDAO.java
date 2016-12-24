package login.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class LoginDAO extends SqlSessionDaoSupport {

	public int login(MemberInfo memberInfo) {
		String passwdFromDB = getSqlSession().selectOne("member.login", memberInfo);
		int checkResult = 0;
		if(passwdFromDB == null) {
			// ��ġ�ϴ� ������ ���� �� 0 ����
			return checkResult;
		}
		boolean passwdMatchResult = BCrypt.checkpw(memberInfo.getM_pass(), passwdFromDB);
		if(passwdMatchResult == false) {
			// ��й�ȣ ����ġ �� -1 ����
			checkResult = -1;
			return checkResult;
		}
		// ��й�ȣ ��ġ �� 1 ����
		checkResult = 1;
		return checkResult;
	}
	
	public String duplicationCheck(MemberInfo memberInfo) {
		
		String check = getSqlSession().selectOne("member.duplicheck", memberInfo);
		return check;
	}
}
