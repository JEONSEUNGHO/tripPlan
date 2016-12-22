package member.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import member.model.MemberInfo;

public class MemberDAO extends SqlSessionDaoSupport {

	public int insertFile(MemberInfo memberInfo) {
		
		// ��й�ȣ ��ȣȭ ó��
		String beforeEncryp = memberInfo.getM_pass();
		
		// �� ��й�ȣ�� BCrypt �˰��� �ؽ� ����, passwordHashed ������ ���� �����ͺ��̽��� ����� 60����Ʈ�� ���ڿ��� �ȴ�.
		String afterEncryp = BCrypt.hashpw(beforeEncryp, BCrypt.gensalt());

		//  ��ȣȭ�� ��й�ȣ�� DB�� �� ������ ���� 
		memberInfo.setM_pass(afterEncryp);
		
		int check = getSqlSession().insert("member.regist", memberInfo);
		return check;
	}
}
