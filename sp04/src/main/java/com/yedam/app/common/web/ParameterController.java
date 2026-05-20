package com.yedam.app.common.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.common.service.UserVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ParameterController {
	// QueryString (질의문자열)
	// format : key=value&key=value&...
	// Content-type : application/x-www-form-urlencoded
	// Http Method : 전부 가능
	// url incoded만 하면 다른 콘텐트타입에 이용 가능
	
	// => 1) 커맨드 객체 : @ 없음. 객체타입
	@RequestMapping("/comobj")
	@ResponseBody // key : value name=hong&age=20
	public String commandObject(UserVO user) {
		log.info("path : /comobj");
		log.info("= name : " + user.getName());
		log.info("= age : " + user.getAge());
		log.info(user.toString());
		return "success";
	}
	// => 2) @RequestParam : @ 존재(default). 기본 테이터형(단일값)
	@RequestMapping("/resparm")
	@ResponseBody
	public String reqparm(Integer age
						, @RequestParam String name
						, @RequestParam(value = "msg"
						, defaultValue = "No message") String message) { // value가 설정이 되면 message 못쓰고 msg만 쓸 수 있음
		log.info("path : /reqparm");
		log.info("= name : " + name);
		log.info("= age : " + age);
		log.info("= message : " + message);
		return "sucess";
	}
	
	// URI에 값을 포함
	// Content-type : 모든 경우 가능
	// Http Method : 모두 가능
	// @PathVaruable : @ 반드시 사용, 기본 데이터형 (단일값)
	@RequestMapping("pathVal/{name}")
//	@RequestMapping("pathVal/{name}/{phone}")  <- 이렇게도 사용가능
	@ResponseBody
	public String pathVariable(@PathVariable String name) {
		log.info("path : /path/{name}");
		log.info("= name : " + name);
		return "home";
	}
	
	// JSON
	// format : {"key" : "value", "key" : "value", ...} or []
	// Content-type : application/json
	// Http Method : POST, PUT
	// @RequestBody : @ 반시기 사용, 객체 or 배열( List 포함 )
	@PostMapping("resbody")
	@ResponseBody
	public Map<String, Object> requestBody(@RequestBody UserVO user){
		Map<String, Object> map = new HashMap<>();
		map.put("path", "resbody");
		map.put("data", user);
		return map;
	}
}
