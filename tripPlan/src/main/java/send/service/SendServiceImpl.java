package send.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import send.dao.SendDAO;
import send.dao.SendDataBean;

public class SendServiceImpl implements SendService {
	@Autowired
	private SendDAO senddao;

	public void setDao(SendDAO senddao) {
		this.senddao = senddao;
	}
	
	
	
	
	
	public int insert(SendDataBean send) {
		int check = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		int sm_id = send.getSm_id();
		
		try{
			map.put("sm_title",send.getSm_title());
			map.put("sm_contents",send.getSm_contents());
			map.put("sm_date",send.getSm_date());
			map.put("sm_receiver",send.getSm_receiver());
			check = senddao.insert("letter.insert", map);
		}catch(Exception e){
			
		}
		System.out.println(check);
		return check;

	}

}
