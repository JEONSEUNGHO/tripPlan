package member.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class MemberDAO extends SqlSessionDaoSupport {

	public int insertFile(MemberInfo memberInfo) {

		System.out.println(memberInfo.getM_profile());
		
		
		int check = getSqlSession().insert("member.regist", memberInfo);
		return check;
	}
}
