package com.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guestbook.repository.GuestBookDao;
import com.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	@Autowired
	GuestBookDao dao;
	
	@RequestMapping("/")
	public String list(Model model) {				//정보를 전달하기 위해 Model 객체를 받는다
		List<GuestBookVo> list = dao.getlist();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute GuestBookVo vo ) {
		dao.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping("/deleteform")
	public String deleteform(@RequestParam("no") int no, Model model) {
		model.addAttribute("no", no);
		return "deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		dao.delete(no, password);
		return "redirect:/";
	}
}
