package logAnalyzer;

import java.util.*;
import java.time.*;

enum Status{
	SUCCESS,
	FAIL;
}
enum Action{
	LOGIN,
	VIEW,
	EDIT,
	LOGOUT;
}
class application{
	String time;
	String Name;
	Action action;
	Status status;	
	
	
	
	application(String time2,String name,Action action,Status status){
		this.time=time2;
		this.Name=name;
		this.action=action;
		this.status=status;
		
	}
}




