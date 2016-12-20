package send.DAO;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class sendDAO extends SqlSessionDaoSupport {
	
	public SendDataBean getSend(int sm_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sm_id", sm_id);
		SendDataBean getSend = getSqlSession().selectOne("send.getSend", map);
		return getSend;
	}
	public int insertsend(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}
	public int deletesend(int sm_id) {
		int check = getSqlSession().delete("send.deletesend", sm_id);
		return check;
	}
	public String deletecheck(int sm_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sm_id", sm_id);

		String check = getSqlSession().selectOne("send.deletecheck", map);

		return check;
	}
}