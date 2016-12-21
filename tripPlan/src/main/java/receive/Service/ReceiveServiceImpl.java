package receive.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import receive.DAO.ReceiveDAO;
import receive.DAO.ReceiveDataBean;

@Controller
public class ReceiveServiceImpl implements ReceiveService {
	@Autowired
	private ReceiveDAO receivedao;

	public void setDao(ReceiveDAO receivedao) {
		this.receivedao = receivedao;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getReceives(int startRow, int endRow, String search, int searchn) {
		List<Object> list = null;

		if (search == null || search.equals(""))
			list = receivedao.getReceives(startRow, endRow);
		else
			list = receivedao.getReceives(startRow, endRow, searchn, search);

		return list;
	}

	public ReceiveDataBean getReceive(int rm_id) {
		ReceiveDataBean list = null;

		try { // city는 mepper파일의 id값에 해당한다.
			list = receivedao.getReceive(rm_id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public int getReceiveCount(String search, int searchn) {
		int count = 0;
		if (search == null || search.equals(""))
			count = receivedao.getReceiveCount();
		else
			count = receivedao.getReceiveCount(searchn, search);

		return count;
	}

	public int insert(ReceiveDataBean receive) {
		int check = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		int rm_id = receive.getRm_id();
		String number = null;
		int number1 = 0;

		number = receivedao.getMax();

		if (number != null)
			number1 = receivedao.getMax1();

		if (number != null) {
			number1 += 1;
		} else {
			number1 = 1;
		}

		try {
			map.put("rm_title", receive.getRm_title());
			map.put("rm_contents", receive.getRm_contents());
			map.put("rm_sender", receive.getRm_sender());
			map.put("m_email", receive.getM_email());
			check = receivedao.insert("letter.insert", map);
		} catch (Exception e) {

		}

		return check;
	}

	public int rdt(int rm_id, String Rm_check) {
		int list;

		String check = receivedao.deletecheck(rm_id);

		if (check.equals(Rm_check)) {

			try {
				list = receivedao.rdt(rm_id); // city는 내가 선택한 도시명
			} catch (Exception e) {

			}
			return 1;
		} else {
			return 0;
		}

	}

	public int updateReceive(ReceiveDataBean receive, int rm_check) {
		Map<String, Object> map = new HashMap<String, Object>();

		String check = receivedao.deletecheck(receive.getRm_id());

		if (check.equals(receive.getRm_check())) {
			map.put("rm_id", receive.getRm_id());
			map.put("rm_title", receive.getRm_title());
			map.put("rm_contents", receive.getRm_contents());
			map.put("rm_date", receive.getRm_date());
			map.put("rm_sender", receive.getRm_sender());
			map.put("m_email", receive.getM_email());

			receivedao.rut(map);

			return 1;
		}

		else
			return 0;

	}

	public void readcount(int rm_id) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("rm_id", rm_id);
		receivedao.readcount(rm_id);
	}

}
