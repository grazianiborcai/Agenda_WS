package br.com.gda.common;

public final class SystemCode {
	// General
	public static final int MANDATORY_FIELD_EMPTY = 1;
	public static final int NO_ERROR_FOUND = 2;	
	public static final int SUCCESS = 200;
	public static final int INTERNAL_ERROR = 500;
	
	// Employee Working Time
	public static final int EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB 	= 1000;
	public static final int EMPLOYEE_WORKING_TIME_DONT_EXIST_ON_DB 		= 1001;
	public static final int EMPLOYEE_WORKING_FLAGGED_AS_DELETED 		= 1002;
	
	// Employee
	public static final int EMPLOYEE_ALREALDY_EXIST_ON_DB 				= 1050;
	public static final int EMPLOYEE_DONT_EXIST_ON_DB 					= 1051;
	public static final int EMPLOYEE_FLAGGED_AS_DELETED 				= 1052;
}
