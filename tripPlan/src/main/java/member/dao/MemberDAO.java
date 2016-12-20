package member.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class MemberDAO extends SqlSessionDaoSupport {

	public int insertFile(MemberInfo memberInfo) {
		System.out.println(memberInfo.getM_email());
		System.out.println(memberInfo.getM_pass());
		System.out.println(memberInfo.getM_nickname());
		System.out.println(memberInfo.getM_sex());
		System.out.println(memberInfo.getM_agerange());
		System.out.println(memberInfo.getM_profile());
		System.out.println(memberInfo.getM_identified());
		
		int check = getSqlSession().insert("member.regist", memberInfo);
		return check;
	}
}
