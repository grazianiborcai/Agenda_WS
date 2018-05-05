package br.com.gda.common;

public final class SystemCode {
	// General
	public static final int MANDATORY_FIELD_EMPTY 						= 1;
	public static final int NO_ERROR_FOUND 								= 2;	
	public static final int CPF_INVALID 								= 3;
	public static final int CNPJ_INVALID 								= 4;
	public static final int KEY_FIELD_NOT_NULL							= 5;
	public static final int KEY_FIELD_IS_EMPTY							= 6;
	public static final int SUCCESS 									= 200;
	public static final int INTERNAL_ERROR 								= 500;
	
	// Employee Working Time
	public static final int EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB 	= 1000;
	public static final int EMPLOYEE_WORKING_TIME_DONT_EXIST_ON_DB 		= 1001;
	public static final int EMPLOYEE_WORKING_FLAGGED_AS_DELETED 		= 1002;
	
	// Employee
	public static final int EMPLOYEE_ALREALDY_EXIST_ON_DB 				= 1050;
	public static final int EMPLOYEE_DONT_EXIST_ON_DB 					= 1051;
	public static final int EMPLOYEE_FLAGGED_AS_DELETED 				= 1052;
	public static final int EMPLOYEE_MULTIPLE_ENTRIES_FOUND				= 1053;
	public static final int EMPLOYEE_SINGLE_ENTRY_FOUND					= 1054;
	public static final int EMPLOYEE_CPF_ALREADY_EXIST					= 1055;
	public static final int EMPLOYEE_CPF_NOT_FOUND						= 1056;	
	public static final int AUTO_GENERATED_FIELD_IS_NOT_EMPTY			= 1057;
	
	// Store
	public static final int STORE_CNPJ_ALREADY_EXIST					= 1100;
	public static final int STORE_CNPJ_NOT_FOUND						= 1101;
	public static final int STORE_ALREALDY_EXIST_ON_DB 					= 1102;
	public static final int STORE_DONT_EXIST_ON_DB 						= 1103;
}
