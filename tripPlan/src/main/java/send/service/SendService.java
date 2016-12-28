package send.service;

import java.util.List;

import send.dao.SendDataBean;

public interface SendService {
	public int insert(SendDataBean send);
	public List<SendDataBean> getSends(int startRow,int endRow);
}
