package send.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import send.DAO.SendDAO;
import send.DAO.SendDataBean;

@Controller
public class SendServiceImpl implements SendService {
	@Autowired
	private SendDAO dao;

	public void setDao(SendDAO dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getSends(int startRow, int endRow, String search, int searchn) {
		List<Object> list = null;

		if (search == null || search.equals(""))
			list = dao.getSends(startRow, endRow);
		else
			list = dao.getSends(startRow, endRow, searchn, search);

		return list;
	}

	public SendDataBean getSend(int sm_id) {
		SendDataBean list = null;

		try {
			list = dao.getSend(sm_id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public int getSendCount(String search, int searchn) {
		int count = 0;
		if (search == null || search.equals(""))
			count = dao.getSendCount();
		else
			count = dao.getSendCount(searchn, search);

		return count;
	}

	public int insert(SendDataBean send) {
		int check = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		int sm_id = send.getSm_id();
		String number = null;
		int number1 = 0;

		number = dao.getMax();

		if (number != null)
			number1 = dao.getMax1();

		if (number != null) {
			number1 += 1;
		} else {
			number1 = 1;
		}

		try {
			map.put("sm_title", send.getSm_title());
			map.put("sm_contents", send.getSm_contents());
			map.put("sm_date", send.getSm_date());
			map.put("sm_sender", send.getSm_receive());
			map.put("m_email", send.getM_email());
			check = dao.Insert("letter.insert", map);
		} catch (Exception e) {

		}

		return check;
	}

	public int sdt(int sm_id, String sm_check) {
		int list;

		String check = dao.deletecheck(sm_id);

		if (check.equals(sm_check)) {

			try {
				list = dao.sdt(sm_id);
			} catch (Exception e) {

			}
			return 1;
		} else {
			return 0;
		}

	}

	public int updateSend(SendDataBean send, int sm_check) {
		Map<String, Object> map = new HashMap<String, Object>();

		String check = dao.deletecheck(send.getSm_id());

		if (check.equals(send.getSm_check())) {
			map.put("sm_id", send.getSm_id());
			map.put("sm_title", send.getSm_title());
			map.put("sm_contents", send.getSm_contents());
			map.put("sm_date", send.getSm_date());
			map.put("sm_sender", send.getSm_receive());
			map.put("m_email", send.getM_email());

			dao.sut(map);

			return 1;
		}

		else
			return 0;

	}

	public void readcount(int sm_id) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sm_id", sm_id);
		dao.readcount(sm_id);
	}

}
