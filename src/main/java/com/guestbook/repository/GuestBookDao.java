package com.guestbook.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guestbook.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int delete(int no, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		
		return sqlSession.delete("guestbook.delete", map);
	}

	public int insert(GuestBookVo vo) {
		return sqlSession.insert("guestbook.insert", vo);
	}

	public List<GuestBookVo> getlist() {
		List<GuestBookVo> list = sqlSession.selectList("guestbook.getList");
		return list;	
	}

}
