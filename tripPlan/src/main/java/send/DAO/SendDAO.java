package send.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SendDAO extends SqlSessionDaoSupport {
	public List<Object> getSends(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> getSends = getSqlSession().selectList("letter.getSends", map);
		return getSends;
	}

	public int getSendCount() {
		int count = getSqlSession().selectOne("letter.getSendCount", Integer.class); // ½ÇÇà
		return count;
	}

	public SendDataBean getSend(int sm_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sm_id", sm_id);
		SendDataBean getSend = getSqlSession().selectOne("letter.getSend", map);
		return getSend;
	}

	public int Insert(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}

	public String deletecheck(int sm_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sm_id", sm_id);

		String del = getSqlSession().selectOne("letter.sdt", map);

		return del;
	}

	public int sdt(int sm_id) {
		int check = getSqlSession().delete("letter.sdt", sm_id);
		return check;
	}

	public int sut(Map<String, Object> map) {
		getSqlSession().update("letter.sut", map);
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

	public void readcount(int sm_id) {
		int i = getSqlSession().update("letter.readcount", sm_id);
	}

	public int getSendCount(int n, String searchKeyword) {
		int x = 0;
		Map map = new HashMap<String, Object>();
		map.put("searchN", n);
		map.put("searchKeyword", searchKeyword);
		x = getSqlSession().selectOne("letter.getSendCount", Integer.class);
		return x;
	}

	public List getSends(int start, int end, int n, String searchKeyword) {
		Map map = new HashMap<String, Object>();
		map.put("startRow", start);
		map.put("endRow", end);
		map.put("searchN", n);
		map.put("searchKeyword", searchKeyword);

		List list = getSqlSession().selectList("letter.searchgetReceives", map);
		return list;
	}

}
