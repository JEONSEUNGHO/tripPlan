package send.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SendDAO extends SqlSessionDaoSupport {
	public int insert(String string, SendDataBean send) {
		System.out.println("2��° insert ȣ��");
		int check = getSqlSession().insert(string, send);
		return check;
	}
	public List<SendDataBean> getSends(int startRow, int endRow) {
		System.out.println("getSends ȣ��");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<SendDataBean> getSends = getSqlSession().selectList("letter.getSends", map);
		System.out.println("getSends ȣ�� ��");
		return getSends;
	}

}
