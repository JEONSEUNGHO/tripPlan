package member.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class MemberDAO extends SqlSessionDaoSupport {

	public int insertFile(MemberInfo memberInfo) {
		
		// 비밀번호 암호화 처리
		String beforeEncryp = memberInfo.getM_pass();
		
		// 위 비밀번호의 BCrypt 알고리즘 해쉬 생성, passwordHashed 변수는 실제 데이터베이스에 저장될 60바이트의 문자열이 된다.
		String afterEncryp = BCrypt.hashpw(beforeEncryp, BCrypt.gensalt());

		//  암호화된 비밀번호를 DB에 들어갈 변수에 저장 
		memberInfo.setM_pass(afterEncryp);
		
		int check = getSqlSession().insert("member.regist", memberInfo);
		return check;
	}
}
