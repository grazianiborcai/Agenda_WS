package br.com.gda.common;

public final class SystemCode {
	// General
	public static final int MANDATORY_FIELD_EMPTY 						= 1;
	public static final int NO_ERROR_FOUND 								= 2;	
	public static final int CPF_INVALID 								= 3;
	public static final int CNPJ_INVALID 								= 4;
	public static final int KEY_FIELD_NOT_NULL							= 5;
	public static final int KEY_FIELD_IS_EMPTY							= 6;
	public static final int BAD_TIME_RANGE								= 7;
	public static final int NO_CONFLICT									= 8;
	public static final int CONFLICT									= 9;
	public static final int DATA_NOT_FOUND								= 10;
	public static final int BAD_DATE									= 11;
	public static final int AGED_DATE									= 12;
	public static final int SUCCESS 									= 200;
	public static final int INTERNAL_ERROR 								= 500;
	
	// Employee Working Time
	public static final int EMP_WTIME_ALREADY_EXIST 					= 1000;
	public static final int EMP_WTIME_NOT_FOUND 						= 1001;
	public static final int EMP_WTIME_FLAGGED_AS_DELETED 				= 1002;
	public static final int EMP_WTIME_RANGE_CONFLICT 					= 1003;
	public static final int EMP_WTIME_NO_RANGE_FOUND 					= 1004;
	public static final int EMP_WTIME_VALID_WORKHOUR					= 1005;
	public static final int EMP_WTIME_WORKHOUR_OUT_OF_RANGE				= 1006;
	
	// Employee
	public static final int EMP_ALREADY_EXIST 							= 1050;
	public static final int EMP_NOT_FOUND 								= 1051;
	public static final int EMP_FLAGGED_AS_DELETED 						= 1052;
	public static final int EMP_MULTIPLE_ENTRIES_FOUND					= 1053;
	public static final int EMP_SINGLE_ENTRY_FOUND						= 1054;
	public static final int EMP_CPF_ALREADY_EXIST						= 1055;
	public static final int EMP_CPF_NOT_FOUND							= 1056;	
	public static final int AUTO_GENERATED_FIELD_IS_NOT_EMPTY			= 1057;
	
	// Store
	public static final int STORE_CNPJ_ALREADY_EXIST					= 1100;
	public static final int STORE_CNPJ_NOT_FOUND						= 1101;
	public static final int STORE_ALREADY_EXIST 						= 1102;
	public static final int STORE_NOT_FOUND 							= 1103;
	public static final int STORE_EMP_ALREADY_EXIST 					= 1104;
	public static final int STORE_EMP_NOT_FOUND 						= 1105;
	public static final int STORE_EMP_FLAGGED_AS_DELETED 				= 1106;	
	public static final int STORE_MAT_EMP_ALREADY_EXIST 				= 1107;
	public static final int STORE_MAT_EMP_NOT_FOUND 					= 1108;
	public static final int STORE_MAT_EMP_FLAGGED_AS_DELETED 			= 1109;
	public static final int STORE_WTIME_NOT_FOUND 						= 1110;
	public static final int STORE_WTIME_ALREADY_EXIST					= 1111;
	public static final int STORE_WTIME_FLAGGED_AS_DELETED 				= 1112;		
	public static final int STORE_LDATE_NOT_FOUND 						= 1113;
	public static final int STORE_LDATE_ALREADY_EXIST					= 1114;
	public static final int STORE_LDATE_FLAGGED_AS_DELETED 				= 1115;	
	public static final int STORE_WTIME_VALID_WORKHOUR					= 1116;
	public static final int STORE_WTIME_WORKHOUR_OUT_OF_RANGE			= 1117;
	public static final int STORE_MAT_ALREADY_EXIST 					= 1118;
	public static final int STORE_MAT_NOT_FOUND 						= 1119;
	public static final int STORE_MAT_FLAGGED_AS_DELETED 				= 1120;
	public static final int STORE_WTIME_NO_LEAVE_FOUND					= 1121;
	public static final int STORE_WTIME_LEAVE_FOUND						= 1122;
	public static final int STORE_FEE_ALREADY_EXIST 					= 1123;
	public static final int STORE_FEE_NOT_FOUND 						= 1124;
	
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
	public static final int WEEKDAY_ALREADY_EXIST						= 1164;
	public static final int WEEKDAY_NOT_FOUND							= 1165;
	public static final int TIMEZONE_ALREADY_EXIST						= 1166;
	public static final int TIMEZONE_NOT_FOUND							= 1167;
	public static final int GENDER_ALREADY_EXIST						= 1168;
	public static final int GENDER_NOT_FOUND							= 1169;	
	public static final int COUNTRY_ALREADY_EXIST						= 1170;
	public static final int COUNTRY_NOT_FOUND							= 1171;
	public static final int FEE_CATEG_ALREADY_EXIST						= 1172;
	public static final int FEE_CATEG_NOT_FOUND							= 1173;
	
	//Material
	public static final int MAT_ALREADY_EXIST							= 1200;
	public static final int MAT_NOT_FOUND								= 1201;
	public static final int MAT_TEXT_ALREADY_EXIST						= 1202;
	public static final int MAT_TEXT_NOT_FOUND							= 1203;	
	public static final int MAT_SERVICE									= 1204;
	public static final int MAT_NOT_SERVICE								= 1205;
	
	//Owner
	public static final int OWNER_ALREADY_EXIST							= 1250;
	public static final int OWNER_NOT_FOUND								= 1251;
	
	// Employee Leave Date
	public static final int EMP_LDATE_ALREADY_EXIST 					= 1300;
	public static final int EMP_LDATE_NOT_FOUND 						= 1301;
	public static final int EMP_LDATE_FLAGGED_AS_DELETED 				= 1302;
	public static final int EMP_LDATE_NO_LEAVE_FOUND					= 1303;
	public static final int EMP_LDATE_LEAVE_FOUND						= 1304;
	
	//Customer
	public static final int CUS_CPF_ALREADY_EXIST						= 1350;
	public static final int CUS_CPF_NOT_FOUND							= 1351;	
	public static final int CUS_EMAIL_ALREADY_EXIST						= 1352;
	public static final int CUS_EMAIL_NOT_FOUND							= 1353;	
	public static final int CUS_ALREADY_EXIST 							= 1354;
	public static final int CUS_NOT_FOUND 								= 1355;
	public static final int CUS_EMAIL_CHANGED 							= 1356;
	public static final int CUS_EMAIL_NOT_CHANGED						= 1357;
	
	//Cart
	public static final int CART_ALREADY_EXIST							= 1400;
	public static final int CART_NOT_FOUND								= 1401;
	public static final int CART_ITEM_ALREADY_EXIST 					= 1402;
	public static final int CART_ITEM_NOT_FOUND 						= 1403;
	public static final int CART_HAVE_ITEM 								= 1404;
	public static final int CART_IS_EMPTY 								= 1405;	
	public static final int CART_MAT_ALREADY_EXIST 						= 1406;
	public static final int CART_MAT_NOT_FOUND 							= 1407;
	
	//Order
	public static final int ORDER_STATUS_ALREADY_EXIST 					= 1450;
	public static final int ORDER_STATUS_NOT_FOUND 						= 1451;
	
	//Total Amount
	public static final int AMOUNT_DONT_HAVE_TWO_DECIMAL_PLACES			= 1500;
}
