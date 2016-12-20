package receive.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class receiveDAO extends SqlSessionDaoSupport {
	
	public ReceiveDataBean getReceive(int rm_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("rm_id", rm_id);
		ReceiveDataBean getReceive = getSqlSession().selectOne("receive.getReceive", map);
		return getReceive;
	}
	public int insertreceive(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}
	public int deletereceive(int rm_id) {
		int check = getSqlSession().delete("receive.deletereceive", rm_id);
		return check;
	}
	public String deletecheck(int rm_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("rm_id", rm_id);

		String check = getSqlSession().selectOne("receive.deletecheck", map);

		return check;
	}
	public List<Object> getReceives(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getReceives = getSqlSession().selectList("receive.getReceives", map);
		System.out.println(getReceives.size());
		return getReceives;
	}

	public int getReceiveCount() {
		int count = getSqlSession().selectOne("receive.getReceiveCount", Integer.class);																	// ½ÇÇà
		return count;
	}

}
