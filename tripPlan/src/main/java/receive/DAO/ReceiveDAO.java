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

	public ReceiveDataBean getReceive(int rm_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("rm_id", rm_id);
		ReceiveDataBean getReceive = getSqlSession().selectOne("letter.getReceive", map);
		return getReceive;
	}

	public int Insert(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}

	public String deletecheck(int rm_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("rm_id", rm_id);

		String del = getSqlSession().selectOne("letter.delete", map);

		return del;
	}

	public int rdt(int rm_id) {
		int check = getSqlSession().delete("letter.delete", rm_id);
		return check;
	}

	public int rut(Map<String, Object> map) {
		getSqlSession().update("letter.update", map);
		return 1;
	}

	public String getMax() {
		String number = getSqlSession().selectOne("letter.getMax");
		return number;
	}

	public int getMax1() {
		
		int number = getSqlSession().selectOne("letter.getMax1");
		
		return number;
	}

	public void readcount(int rm_id) {
		int i = getSqlSession().update("letter.readcount", rm_id);
	}

	public int getReceiveCount(int n, String searchKeyword){
		int x = 0;
		Map map = new HashMap<String,Object>();	
		map.put("searchN", n);
		map.put("searchKeyword", searchKeyword);
		x = getSqlSession().selectOne("letter.getReceiveCount", Integer.class); // cityMapper		
		return x;
	}

	public List getReceives(int start, int end, int n, String searchKeyword){
		Map map = new HashMap<String,Object>();
		map.put("startRow", start);
		map.put("endRow", end);
		map.put("searchN", n);
		map.put("searchKeyword", searchKeyword);
		
		List list = getSqlSession().selectList("letter.searchgetReceives",map);
		return list;
	}

}
