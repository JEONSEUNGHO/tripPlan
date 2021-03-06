package login.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class LoginDAO extends SqlSessionDaoSupport {

	public int login(MemberInfo memberInfo) {
		String passwdFromDB = getSqlSession().selectOne("member.login", memberInfo);
		int checkResult = 0;
		if(passwdFromDB == null) {
			// 일치하는 정보가 없을 시 0 리턴
			return checkResult;
		}
		boolean passwdMatchResult = BCrypt.checkpw(memberInfo.getM_pass(), passwdFromDB);
		if(passwdMatchResult == false) {
			// 비밀번호 불일치 시 -1 리턴
			checkResult = -1;
			return checkResult;
		}
		// 비밀번호 일치 시 1 리턴
		checkResult = 1;
		return checkResult;
	}
	
	public String duplicationCheck(MemberInfo memberInfo) {
		
		String check = getSqlSession().selectOne("member.duplicheck", memberInfo);
		return check;
	}
	
	public void changeMemberInfo(MemberInfo memberInfo) {
		getSqlSession().update("member.changeMemberInfo",memberInfo);
	}
}
