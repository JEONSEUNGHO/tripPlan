package send.Service;

import java.util.List;

import org.springframework.stereotype.Controller;

import send.DAO.SendDataBean;

@Controller
public interface SendService {
	public List<Object> getSends(int startRow,int endRow,String search, int searchn);
	public SendDataBean getSend(int sm_id);
	public int getSendCount(String search, int searchn);
	public int insert(SendDataBean send);
	public int sdt(int sm_id, String sm_check);
	public int updateSend(SendDataBean send,int sm_check);
	public void readcount(int sm_id);

}
