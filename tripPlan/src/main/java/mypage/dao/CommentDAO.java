package mypage.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import mypage.model.CommentDTO;

public class CommentDAO extends SqlSessionDaoSupport {

	/*
	 * reply method
	 */
	public List<CommentDTO> selectReply(int b_id) {
		List<CommentDTO> replyList = new ArrayList<>();
		replyList = getSqlSession().selectList("member.selectComment", b_id);
		return replyList;
	}

	public int insertReply(CommentDTO reply) {
		return getSqlSession().insert("member.insertComment", reply);
	}

	public int deleteReply(int re_id) {
		return getSqlSession().delete("member.deleteComment", re_id);
	}

}
