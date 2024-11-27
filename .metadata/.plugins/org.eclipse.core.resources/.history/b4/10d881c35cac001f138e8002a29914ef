package org.doit.ik.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	//DB에서 현재 시간을 읽어온다
	String getTime();
	
	@Select("SELECT SYSDATE +1 FROM dual")
	String getNextTime();//다음날짜
}
