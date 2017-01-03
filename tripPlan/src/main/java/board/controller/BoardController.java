package board.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardDAO;
import board.model.BoardDTO;
import board.model.SubBoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	BoardDAO dao;
	private SimpleDateFormat formatter;
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	//경로생성 클릭 후 첫 페이지
	@RequestMapping(value="/createBoard.do", method=RequestMethod.GET)
	public String createBoardForm(){
		return "createBoard";
	}
	
	//경로 생성 클릭 후 mainBoard 작성 후 다음 클릭 시
	@RequestMapping(value="/createBoard.do", method=RequestMethod.POST)
	public ModelAndView submitMainBoard(String maintitle, String identified, String mainphoto, String maincontents){			//jsp에서 값 받아와야함
		ModelAndView mav = new ModelAndView("createSubBoard");
		/*BoardDTO board = new BoardDTO(maintitle,maincontents,mainphoto,0,currentTime(),0,currentTime(),1,"cool4706@naver.com");								//값 받아와서 생성자에 넣어줘야함
		int check = dao.insertMainBoard(board);
		mav.addObject("check", check);*/
		return mav;
	}
	//mainBoard에서 다음 버튼 클릭 후 화면
	@RequestMapping(value="/createSubBoard.do", method=RequestMethod.GET)
	public String createSubBoardForm(){
		return "createSubBoard";
	}
	
	//subBoard에서 완료 버튼 클릭 시
	@RequestMapping(value="/createSubBoard.do", method=RequestMethod.POST)	//수정 필요
	public ModelAndView submitSubBoard(String[] sb_lat, String[] sb_lon, String[] sb_subcontent, String[] sb_tcharge, String[] sb_fcharge, String[] sb_rcharge){
		ModelAndView mav = new ModelAndView("isCreateBoard");
		SubBoardDTO subBoard = null;
		int check = 0;
		for(int i=0; i<sb_lat.length;i++){
			subBoard = new SubBoardDTO(sb_subcontent[i],Integer.parseInt(sb_tcharge[i]),Integer.parseInt(sb_fcharge[i]),Integer.parseInt(sb_rcharge[i]),currentTime(),
					"1","2","3","4","5",sb_lat[i],sb_lon[i],i+1,1);
			System.out.println(subBoard);
			check = dao.insertSubBoard(subBoard);
		}
		mav.addObject("check", check);
		return mav;
	}
	//각 게시판 별 mainBoardList 조회
	@RequestMapping(value="/reviewBoard.do", method=RequestMethod.GET)
	public ModelAndView selectAllMainBoard(int identified){
		ModelAndView mav = new ModelAndView("reviewBoard");
		List<BoardDTO> mainBoardList = new ArrayList<>();
		mainBoardList = dao.mainBoardAll(identified);
		mav.addObject("mainBoardList", mainBoardList);
		return mav;
	}
	public String currentTime(){
		formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return formatter.format(new Date());
	}
}
