package member.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import member.model.MemberInfo;

public class MemberDAO extends SqlSessionDaoSupport {

	public int insertFile(MemberInfo memberInfo) {
		
		// 비밀번호 암호화 처리
		String beforeEncryp = memberInfo.getM_pass();
		
		// 위 비밀번호의 BCrypt 알고리즘 해쉬 생성, passwordHashed 변수는 실제 데이터베이스에 저장될 60바이트의 문자열이 된다.
		String afterEncryp = BCrypt.hashpw(beforeEncryp, BCrypt.gensalt(10));

		//  암호화된 비밀번호를 DB에 들어갈 변수에 저장 
		memberInfo.setM_pass(afterEncryp);
		
		int check = getSqlSession().insert("member.regist", memberInfo);
		return check;
	}
	
	public String duplicationCheck(MemberInfo memberInfo) {
		
		String check = getSqlSession().selectOne("member.duplicheck", memberInfo);
		return check;
	}
	
	public void updatePW(MemberInfo memberInfo) {
		
		// 비밀번호 암호화 처리
		String beforeEncryp = memberInfo.getTempPW();
		
		// 위 비밀번호의 BCrypt 알고리즘 해쉬 생성, passwordHashed 변수는 실제 데이터베이스에 저장될 60바이트의 문자열이 된다.
		String afterEncryp = BCrypt.hashpw(beforeEncryp, BCrypt.gensalt(10));

		//  암호화된 비밀번호를 DB에 들어갈 변수에 저장 
		memberInfo.setTempPW(afterEncryp);
		
		getSqlSession().update("member.updatepw", memberInfo);
	}
	
	public int realTimeIdchk(String m_email) {

		String check = getSqlSession().selectOne("member.realtimeidchk", m_email);
		if(check==null) {
			check="";
			// 가입가능
			return 0;
		}
		// 가입불가
		return 1;
	}
	
	
}
