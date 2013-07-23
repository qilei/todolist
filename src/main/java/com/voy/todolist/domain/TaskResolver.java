package com.voy.todolist.domain;

import java.util.Calendar;

public class TaskResolver {
	public static Task resolve(String taskInfo){
		String task="";
		String duration="";
		String priority="";
		boolean skipTask=false;
		boolean skipDuration=false;
		char[] charArray=taskInfo.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char cur=charArray[i];
			if(!skipTask && cur!='@' && cur!='!'){
				task+=cur;
			}else if(cur=='@'){
				skipTask=true;
				continue;
			}else if(cur=='!'){
				skipDuration=true;
				continue;
			}else if(skipTask && !skipDuration){
				duration+=cur;
			}else if(skipDuration){
				priority+=cur;
			}
		}
		Task result=new Task();
		result.setInfo(task.trim());
		result.setPriority(priority.trim());
		result.setDuration(duration.trim());
		result.setDueDate(Calendar.getInstance().getTime());
		return result;
	}
}
