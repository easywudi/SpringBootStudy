package com.study.utils;

import com.study.domain.Result;

public class ResultUtil {
	
	public static Result success (Object o) {
		Result rs = new Result();
		rs.setCode(0);
		rs.setDate(o);
		rs.setMsg("成功");
		return rs;
	}
	
	public static Result success () {
		return success(null);
	}
	
	public static Result error (Integer code,String msg) {
		Result rs = new Result();
		rs.setCode(code);
		rs.setMsg(msg);
		return rs;
	}

}
