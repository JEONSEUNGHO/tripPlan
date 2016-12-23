package login.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class LoginDAO extends SqlSessionDaoSupport {

	public int login(MemberInfo memberInfo) {
		System.out.println("dao ���� �� �̸���"+memberInfo.getM_email());
		String passwdFromDB = getSqlSession().selectOne("member.login", memberInfo);
		System.out.println(passwdFromDB);
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
}
