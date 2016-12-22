package receive.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ReceiveDAO extends SqlSessionDaoSupport {
	public List<Object> getReceives(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getReceives = getSqlSession().selectList("letter.getReceives", map);
		return getReceives;
	}

	public int getReceiveCount() {
		int count = getSqlSession().selectOne("letter.getReceiveCount", Integer.class); // cityMapper																		// ½ÇÇà
		return count;
	}
}
