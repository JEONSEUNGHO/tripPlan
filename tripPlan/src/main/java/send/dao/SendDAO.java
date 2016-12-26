package send.dao;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SendDAO extends SqlSessionDaoSupport {
	public int insert(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		System.out.println(check);
		return check;
	}

}
