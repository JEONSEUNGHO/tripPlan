package send.Service;

import java.util.List;

import org.springframework.stereotype.Controller;

import receive.DAO.ReceiveDataBean;
import send.DAO.SendDataBean;

@Controller
public interface sendService {
	public List<Object> getSends(int startRow, int endRow, String search, int searchn);
	public SendDataBean getSend(int sm_id);
	public  int getSendCount(String search, int searchn);
	public int insertsend(SendDataBean send);
	public int deletesend(int sm_id);
	public int updatesend(SendDataBean send);
	public void readcount(int sm_id);
}
