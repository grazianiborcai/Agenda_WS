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
	public static final int EMPLOYEE_WORKING_TIME_ALREADY_EXIST 		= 1000;
	public static final int EMPLOYEE_WORKING_TIME_NOT_FOUND 			= 1001;
	public static final int EMPLOYEE_WORKING_FLAGGED_AS_DELETED 		= 1002;
	
	// Employee
	public static final int EMPLOYEE_ALREALDY_EXIST 					= 1050;
	public static final int EMPLOYEE_NOT_FOUND 							= 1051;
	public static final int EMPLOYEE_FLAGGED_AS_DELETED 				= 1052;
	public static final int EMPLOYEE_MULTIPLE_ENTRIES_FOUND				= 1053;
	public static final int EMPLOYEE_SINGLE_ENTRY_FOUND					= 1054;
	public static final int EMPLOYEE_CPF_ALREADY_EXIST					= 1055;
	public static final int EMPLOYEE_CPF_NOT_FOUND						= 1056;	
	public static final int AUTO_GENERATED_FIELD_IS_NOT_EMPTY			= 1057;
	
	// Store
	public static final int STORE_CNPJ_ALREADY_EXIST					= 1100;
	public static final int STORE_CNPJ_NOT_FOUND						= 1101;
	public static final int STORE_ALREALDY_EXIST 						= 1102;
	public static final int STORE_DONT_EXIST 							= 1103;
	public static final int STORE_EMP_ALREALDY_EXIST 					= 1104;
	public static final int STORE_EMP_NOT_FOUND 						= 1105;
	public static final int STORE_EMP_FLAGGED_AS_DELETED 				= 1106;
	
	// Master Data
	public static final int EMP_POS_ALREADY_EXIST						= 1150;
	public static final int EMP_POS_NOT_FOUND							= 1151;
	public static final int LANGUAGE_ALREADY_EXIST						= 1152;
	public static final int LANGUAGE_NOT_FOUND							= 1153;
	public static final int CURRENCY_ALREADY_EXIST						= 1154;
	public static final int CURRENCY_NOT_FOUND							= 1155;
	public static final int UNIT_ALREADY_EXIST							= 1156;
	public static final int UNIT_NOT_FOUND								= 1157;
	public static final int MAT_CATEG_ALREADY_EXIST						= 1158;
	public static final int MAT_CATEG_NOT_FOUND							= 1159;
	public static final int MAT_GROUP_ALREADY_EXIST						= 1160;
	public static final int MAT_GROUP_NOT_FOUND							= 1161;
	public static final int MAT_TYPE_ALREADY_EXIST						= 1162;
	public static final int MAT_TYPE_NOT_FOUND							= 1163;
	
	//Material
	public static final int MATERIAL_ALREADY_EXIST						= 1200;
	public static final int MATERIAL_NOT_FOUND							= 1201;
	public static final int MATERIAL_TEXT_ALREADY_EXIST					= 1202;
	public static final int MATERIAL_TEXT_NOT_FOUND						= 1203;
}
