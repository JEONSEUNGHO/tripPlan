package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BoardDAO extends SqlSessionDaoSupport{
	
	public List<SubBoardDTO> zzz(int num){
		List<SubBoardDTO> board = new ArrayList<SubBoardDTO>();
		board = getSqlSession().selectList("board.zzz",num);
		return board;
	}
	public List<TotalBoardDTO> selectBoardContents(int b_id){
		List<TotalBoardDTO> boardContents = new ArrayList<>();
		boardContents = getSqlSession().selectList("board.selectBoardContents", b_id);
		System.out.println("boarddao ::"+boardContents.size());
		return boardContents;
	}
	/* 
	 * MainBoard method
	 * */
	public List<BoardDTO> searchzz(Map<String,String> abc){
		List<BoardDTO>board = new ArrayList<BoardDTO>();
		board = getSqlSession().selectList("board.boardSearch",abc);
		return board;
	}
	public List<BoardDTO> searchBoard(String search){
		List<BoardDTO> board = new ArrayList<BoardDTO>();
		board = getSqlSession().selectList("board.mainSearch",search);
		
		return board;
		
	}
	public List<BoardDTO> selectAllBoard() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		boardList = getSqlSession().selectList("board.list");
		return boardList;
	}
	//�� board��  MainBoard ��ȸ
	public List<BoardDTO> mainBoardAll(int identified){
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		boards = getSqlSession().selectList("board.mainBoardAll", identified);
		return boards;
	}
	//MainBoard ����
	public int insertMainBoard(BoardDTO board){
		System.out.println("insertMainBoard ����");
		int check = getSqlSession().insert("board.insertMainBoard", board);
		System.out.println("insertMainBoard insert����");
		return check;
	}
	//MainBoard ����
	public int updateMainBoard(BoardDTO board){
		int check = getSqlSession().update("board.updateMainBoard", board);
		return check;
	}
	//MainBoard ����
	public int deleteMainBoard(int b_id){
		int check = getSqlSession().delete("board.deleteMainBoard", b_id);
		return check;
	}
	
	/* 
	 * SubBoard method
	 * */
	//MainBoard id�� ������ �ִ� ��� SubBoardList ��ȸ
	public List<SubBoardDTO> subBoardAll(int b_id){
		List<SubBoardDTO> subBoard = new ArrayList<>();
		subBoard = getSqlSession().selectList("board.subBoardAll", b_id);
		return subBoard;
	}
	//SubBoard ����
	public int insertSubBoard(SubBoardDTO subBoard){
		int check = getSqlSession().insert("board.insertSubBoard", subBoard);
		return check;
	}
	//SubBoard ����
	public int updateSubBoard(SubBoardDTO subBoard){
		int check = getSqlSession().update("board.updateSubBoard", subBoard);
		return check;
	}
	//������ mainBoard�� �����ϸ� subBoard�� ���� ���� �Ǳ� ������ ������ ����
	
	/*
	 * ����
	 */
	//�̹�������
	public int fileUpload(FileDTO images){
		int check = getSqlSession().insert("board.fileUpload", images);
		return check;
	}
	public String searchFilePath(int fi_id){
		return getSqlSession().selectOne("board.searchFilePath", fi_id);
	}
	
	/*
	 * reply method
	 */
	public List<ReplyDTO> selectReply(int b_id){
		List<ReplyDTO> replyList = new ArrayList<>();
		replyList = getSqlSession().selectList("board.selectReply",b_id);
		return replyList;
	}
	public int insertReply(ReplyDTO reply){
		return getSqlSession().insert("board.insertReply",reply);
	}
	public int deleteReply(int re_id){
		return getSqlSession().delete("board.deleteReply",re_id);
	}
}
