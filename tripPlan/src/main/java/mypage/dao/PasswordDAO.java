package mypage.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import member.model.MemberInfo;

public class PasswordDAO extends SqlSessionDaoSupport {

	public int updatePass(MemberInfo memberInfo) {
		
		// 비밀번호 암호화 처리
		String beforeEncryp = memberInfo.getM_pass1();
		
		// 위 비밀번호의 BCrypt 알고리즘 해쉬 생성, passwordHashed 변수는 실제 데이터베이스에 저장될 60바이트의 문자열이 된다.
		String afterEncryp = BCrypt.hashpw(beforeEncryp, BCrypt.gensalt(10));

		//  암호화된 비밀번호를 DB에 들어갈 변수에 저장 
		memberInfo.setM_pass1(afterEncryp);
		
		int check = getSqlSession().update("member.updatePass", memberInfo);
		// DB에서 불러온 비밀번호와 입력받은 비밀번호를 비교
		if(check == 1) {
			return check;
		} 
		return check;
}

	public int getPass(MemberInfo memberInfo, String m_email) {
		String passwdFromDB = getSqlSession().selectOne("member.getPass", m_email);
		int flag = -1;
		// DB에서 불러온 비밀번호와 입력받은 비밀번호를 비교
		boolean passwdMatchResult = BCrypt.checkpw(memberInfo.getM_pass(), passwdFromDB);
		if(passwdMatchResult == true) {
			flag = 1;
			return flag;
		} 
		return flag;

	}

}
