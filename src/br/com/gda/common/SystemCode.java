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
	public static final int TECH_FIELD_SHOULD_BE_EMPTY					= 13;
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
	public static final int EMP_WTIME_INVALID_RANGE						= 1007;
	public static final int EMP_WTIME_RANGE_TOO_SHORT					= 1008;
	
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
	public static final int STORE_WTIME_NO_LEAVE_FOUND					= 1121;
	public static final int STORE_WTIME_LEAVE_FOUND						= 1122;
	public static final int STORE_FEE_ALREADY_EXIST 					= 1123;
	public static final int STORE_FEE_NOT_FOUND 						= 1124;
	public static final int STORE_TECH_FIELD_SHOULD_BE_EMPTY			= 1125;
	public static final int STORE_WTIME_FLAG_DELETE_TRUE				= 1126;
	public static final int STORE_WTIME_FLAG_DELETE_FALSE				= 1127;
	public static final int STORE_WTIME_HAVE_ITEM 						= 1128;
	public static final int STORE_WTIME_IS_EMPTY 						= 1129;	
	public static final int STORE_LDATE_HAVE_ITEM 						= 1130;
	public static final int STORE_LDATE_IS_EMPTY 						= 1131;	
	public static final int STORE_HAS_ITEM 								= 1132;	
	public static final int STORE_NO_ITEM_FOUND 						= 1133;	
	
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
	public static final int COUNTRY_PHONE_ALREADY_EXIST					= 1174;
	public static final int COUNTRY_PHONE_NOT_FOUND						= 1175;
	public static final int STATE_ALREADY_EXIST							= 1176;
	public static final int STATE_NOT_FOUND								= 1177;
	public static final int AREA_PHONE_ALREADY_EXIST					= 1178;
	public static final int AREA_PHONE_NOT_FOUND						= 1179;
	public static final int ENTITY_CATEG_ALREADY_EXIST					= 1180;
	public static final int ENTITY_CATEG_NOT_FOUND						= 1181;
	public static final int COUNTRY_LEGAL_ALREADY_EXIST					= 1182;
	public static final int COUNTRY_LEGAL_NOT_FOUND						= 1183;
	public static final int ORDER_STATUS_ALREADY_EXIST 					= 1184;
	public static final int ORDER_STATUS_NOT_FOUND 						= 1185;
	public static final int PAYMENT_STATUS_ALREADY_EXIST 				= 1186;
	public static final int PAYMENT_STATUS_NOT_FOUND 					= 1187;
	public static final int USER_CATEG_ALREADY_EXIST					= 1188;
	public static final int USER_CATEG_NOT_FOUND						= 1189;
	public static final int AUTH_GROUP_ALREADY_EXIST					= 1190;
	public static final int AUTH_GROUP_NOT_FOUND						= 1191;
	public static final int MAT_MOV_TYPE_ALREADY_EXIST					= 1192;
	public static final int MAT_MOV_TYPE_NOT_FOUND						= 1193;
	public static final int PAY_PARTNER_ALREADY_EXIST					= 1194;
	public static final int PAY_PARTNER_NOT_FOUND						= 1195;
	
	// Material
	public static final int MAT_ALREADY_EXIST							= 1200;
	public static final int MAT_NOT_FOUND								= 1201;
	public static final int MAT_TEXT_ALREADY_EXIST						= 1202;
	public static final int MAT_TEXT_NOT_FOUND							= 1203;	
	public static final int MAT_SERVICE									= 1204;
	public static final int MAT_NOT_SERVICE								= 1205;
	public static final int MAT_UNIT_EACH_INCONSISTENCY					= 1206;
	public static final int MAT_UNIT_INCONSISTENCY						= 1207;
	public static final int MAT_CATEG_CANT_BE_CHANGED					= 1208;	
	public static final int MAT_CATEG_NOT_CHANGED						= 1209;	
	public static final int MAT_TEXT_NOT_DEFAULT						= 1210;
	public static final int MAT_TEXT_HAS_NO_DEFAULT						= 1211;
	public static final int MAT_TEXT_HAS_DEFAULT						= 1212;
	public static final int MAT_TEXT_DEFAULT_CANT_BE_DELETED			= 1213;
	public static final int MAT_HAS_ITEM								= 1214;
	public static final int MAT_NO_ITEM_FOUND							= 1215;
	
	// Owner
	public static final int OWNER_ALREADY_EXIST							= 1250;
	public static final int OWNER_NOT_FOUND								= 1251;
	public static final int OWNER_TECH_FIELD_SHOULD_BE_EMPTY			= 1252;
	public static final int OWNER_PERSON_NOT_CHANGED					= 1253;
	public static final int OWNER_PERSON_CANT_BE_CHANGED				= 1254;
	
	// Employee Leave Date
	public static final int EMP_LDATE_ALREADY_EXIST 					= 1300;
	public static final int EMP_LDATE_NOT_FOUND 						= 1301;
	public static final int EMP_LDATE_FLAGGED_AS_DELETED 				= 1302;
	public static final int EMP_LDATE_NO_LEAVE_FOUND					= 1303;
	public static final int EMP_LDATE_LEAVE_FOUND						= 1304;
	
	// Customer
	public static final int CUS_CPF_ALREADY_EXIST						= 1350;
	public static final int CUS_CPF_NOT_FOUND							= 1351;	
	public static final int CUS_EMAIL_ALREADY_EXIST						= 1352;
	public static final int CUS_EMAIL_NOT_FOUND							= 1353;	
	public static final int CUS_ALREADY_EXIST 							= 1354;
	public static final int CUS_NOT_FOUND 								= 1355;
	public static final int CUS_EMAIL_CHANGED 							= 1356;
	public static final int CUS_EMAIL_NOT_CHANGED						= 1357;
	public static final int CUS_PERSON_CANT_BE_CHANGED					= 1358;
	public static final int CUS_PERSON_NOT_CHANGED						= 1359;
	public static final int CUS_TECH_FIELD_SHOULD_BE_EMPTY				= 1360;
	public static final int CUS_HAS_CUSTOMER							= 1361;
	public static final int CUS_DONT_HAS_CUSTOMER						= 1362;
	public static final int CUS_HAS_USER								= 1363;
	public static final int CUS_DONT_HAS_USER							= 1364;
	public static final int CUS_HAS_EMAIL								= 1365;
	public static final int CUS_DONT_HAS_EMAIL							= 1366;
	
	// Cart
	public static final int CART_ALREADY_EXIST							= 1400;
	public static final int CART_NOT_FOUND								= 1401;
	public static final int CART_ITEM_ALREADY_EXIST 					= 1402;
	public static final int CART_ITEM_NOT_FOUND 						= 1403;
	public static final int CART_HAVE_ITEM 								= 1404;
	public static final int CART_IS_EMPTY 								= 1405;	
	public static final int CART_MAT_ALREADY_EXIST 						= 1406;
	public static final int CART_MAT_NOT_FOUND 							= 1407;
	public static final int CART_ITEM_IS_NOT_SERVICE 					= 1408;
	public static final int CART_ITEM_IS_NOT_DELETED 					= 1409;
	public static final int CART_ITEM_QUANTITY_ILLEGAL					= 1410;

	// Total Amount
	public static final int AMOUNT_DONT_HAVE_TWO_DECIMAL_PLACES			= 1500;
	
	// Phone
	public static final int PHONE_NUMBER_IS_NULL						= 1550;
	public static final int PHONE_NUMBER_IS_FILLED						= 1551;
	public static final int PHONE_COUNTRY_IS_BR							= 1552;
	public static final int PHONE_COUNTRY_IS_NOT_BR						= 1553;
	public static final int PHONE_NUMBER_INVALID						= 1554;
	public static final int PHONE_NUMBER_IS_VALID						= 1555;
	public static final int PHONE_NUMBER_INVALID_LENGTH_BR				= 1556;
	public static final int PHONE_NUMBER_INVALID_NUMBER					= 1557;
	public static final int PHONE_NUMBER_INVALID_AREA_CODE				= 1558;
	public static final int PHONE_NUMBER_INVALID_SEQUENCE				= 1559;	
	public static final int PHONE_WITHOUT_REFERENCE						= 1660;
	public static final int PHONE_MULTIPLE_REFERENCE					= 1661;
	public static final int PHONE_LIMIT_EXCEEDED						= 1662;
	public static final int PHONE_NUMBER_INVALID_LENGTH					= 1563;
	public static final int PHONE_NOT_FOUND								= 1564;
	public static final int PHONE_ALREADY_EXIST							= 1565;
	public static final int PHONE_IS_NEW								= 1566;
	public static final int PHONE_IS_OLD								= 1567;
	public static final int PHONE_FLAG_DELETE_TRUE						= 1568;
	public static final int PHONE_FLAG_DELETE_FALSE						= 1569;
	public static final int PHONE_IS_NULL								= 1570;
	public static final int PHONE_IS_FILLED								= 1571;
	public static final int PHONE_COD_IS_FILLED							= 1572;
	public static final int PHONE_TECH_FIELD_SHOULD_BE_EMPTY			= 1573;
	public static final int PHONE_COD_IS_BLANK							= 1574;
	
	// Address
	public static final int ADDRESS_IS_NULL								= 1600;
	public static final int ADDRESS_IS_FILLED							= 1601;
	public static final int ADDRESS_NOT_FOUND							= 1602;
	public static final int ADDRESS_ALREADY_EXIST						= 1603;
	public static final int ADDRESS_IS_NEW								= 1604;
	public static final int ADDRESS_IS_OLD								= 1605;
	public static final int ADDRESS_WITHOUT_REFERENCE					= 1606;
	public static final int ADDRESS_MULTIPLE_REFERENCE					= 1607;
	public static final int ADDRESS_FLAG_DELETE_TRUE					= 1608;
	public static final int ADDRESS_FLAG_DELETE_FALSE					= 1609;
	public static final int ADDRESS_LIMIT_EXCEEDED						= 1610;
	public static final int ADDRESS_COD_IS_FILLED						= 1611;
	public static final int ADDRESS_TECH_FIELD_SHOULD_BE_EMPTY			= 1612;
	public static final int ADDRESS_COD_IS_BLANK						= 1613;
	
	// Form
	public static final int FORM_ADDRESS_ALREADY_EXIST					= 1700;
	public static final int FORM_ADDRESS_NOT_FOUND						= 1701;
	public static final int FORM_ADDRESS_INVALID						= 1702;
	public static final int FORM_PHONE_INVALID							= 1703;
	
	// Person
	public static final int PERSON_CPF_BLANK							= 1750;
	public static final int PERSON_CPF_INVALID_NUMBER					= 1751;
	public static final int PERSON_CPF_INVALID_LENGTH					= 1752;
	public static final int PERSON_CPF_INVALID_SEQUENCE					= 1753;
	public static final int PERSON_CPF_INVALID							= 1754;
	public static final int PERSON_CPF_ALREADY_EXIST					= 1755;
	public static final int PERSON_CPF_NOT_FOUND						= 1756;	
	public static final int PERSON_EMAIL_BLANK							= 1757;
	public static final int PERSON_EMAIL_ALREADY_EXIST					= 1758;
	public static final int PERSON_EMAIL_NOT_FOUND						= 1759;	
	public static final int PERSON_ALREADY_EXIST 						= 1760;
	public static final int PERSON_NOT_FOUND 							= 1761;
	public static final int PERSON_EMAIL_CHANGED 						= 1762;
	public static final int PERSON_EMAIL_NOT_CHANGED					= 1763;	
	public static final int PERSON_CPF_CHANGED 							= 1764;
	public static final int PERSON_CPF_NOT_CHANGED						= 1765;
	public static final int PERSON_CPF_CANT_BE_CHANGED					= 1766;
	public static final int PERSON_EMAIL_CANT_BE_CHANGED				= 1767;
	public static final int PERSON_CPF_ERASURE							= 1768;
	public static final int PERSON_CPF_NO_ERASURE						= 1769;
	public static final int PERSON_EMAIL_ERASURE						= 1770;
	public static final int PERSON_EMAIL_NO_ERASURE						= 1771;
	public static final int PERSON_TECH_FIELD_SHOULD_BE_EMPTY			= 1772;
	public static final int PERSON_IS_NULL								= 1773;
	public static final int PERSON_IS_FILLED							= 1774;
	public static final int PERSON_MISMATCH								= 1775;
	
	// User
	public static final int USER_COD_IS_FILLED							= 1800;
	public static final int USER_TECH_FIELD_SHOULD_BE_EMPTY				= 1801;
	public static final int USER_PERSON_NOT_CHANGED						= 1802;
	public static final int USER_PERSON_CANT_BE_CHANGED					= 1803;
	public static final int USER_ALREADY_EXIST 							= 1804;
	public static final int USER_NOT_FOUND 								= 1805;
	public static final int USER_USERNAME_ALREADY_EXIST 				= 1806;
	public static final int USER_USERNAME_NOT_FOUND 					= 1807;
	public static final int USER_IS_NULL								= 1808;
	public static final int USER_IS_FILLED								= 1809;
	
	// Snapshot
	public static final int SNAPSHOT_ALREADY_EXIST 						= 1850;
	public static final int SNAPSHOT_NOT_FOUND 							= 1851;
	
	// PersonUser
	public static final int PERSON_USER_WITHOUT_REFERENCE				= 1900;
	public static final int PERSON_USER_EMAIL_IS_NULL					= 1901;
	public static final int PERSON_USER_EMAIL_IS_FILLED					= 1902;
	public static final int PERSON_USER_CPF_IS_NULL						= 1903;
	public static final int PERSON_USER_CPF_IS_FILLED					= 1904;
	public static final int PERSON_USER_ALREADY_EXIST					= 1905;
	public static final int PERSON_USER_NOT_FOUND						= 1906;
	
	// Address Snapshot
	public static final int ADDRESS_SNAPSHOT_IS_NULL 					= 2000;	
	public static final int ADDRESS_SNAPSHOT_IS_FILLED 					= 2001;	
	public static final int ADDRESS_SNAPSHOT_NOT_FOUND					= 2002;
	public static final int ADDRESS_SNAPSHOT_ALREADY_EXIST				= 2003;
	
	// Phone Snapshot
	public static final int PHONE_SNAPSHOT_IS_NULL 						= 2050;	
	public static final int PHONE_SNAPSHOT_IS_FILLED 					= 2051;	
	public static final int PHONE_SNAPSHOT_NOT_FOUND					= 2052;
	public static final int PHONE_SNAPSHOT_ALREADY_EXIST				= 2053;
	
	// Person Snapshot
	public static final int PERSON_SNAPSHOT_IS_NULL 					= 2100;	
	public static final int PERSON_SNAPSHOT_NOT_FOUND					= 2101;
	public static final int PERSON_SNAPSHOT_ALREADY_EXIST				= 2102;
	
	// PersonCustomer
	public static final int PERSON_CUS_WITHOUT_REFERENCE				= 2150;
	public static final int PERSON_CUS_EMAIL_IS_NULL					= 2101;
	public static final int PERSON_CUS_EMAIL_IS_FILLED					= 2102;
	public static final int PERSON_CUS_CPF_IS_NULL						= 2103;
	public static final int PERSON_CUS_CPF_IS_FILLED					= 2104;
	public static final int PERSON_CUS_ALREADY_EXIST					= 2105;
	public static final int PERSON_CUS_NOT_FOUND						= 2106;
	
	// User Snapshot
	public static final int USER_SNAPSHOT_ALREADY_EXIST 				= 2150;
	public static final int USER_SNAPSHOT_NOT_FOUND 					= 2151;
	public static final int USER_SNAPSHOT_IS_NULL 						= 2152;	
	public static final int USER_SNAPSHOT_NO_ADDRESS					= 2153;	
	public static final int USER_SNAPSHOT_NO_PHONE						= 2154;
	
	// Material Snapshot
	public static final int MATERIAL_SNAPSHOT_IS_NULL 					= 2200;	
	public static final int MATERIAL_SNAPSHOT_ALREADY_EXIST 			= 2201;
	public static final int MATERIAL_SNAPSHOT_NOT_FOUND 				= 2202;
	public static final int MATERIAL_SNAPSHOT_TEXT_NOT_FOUND			= 2203;
	public static final int MATERIAL_SNAPSHOT_TEXT_ALREADY_EXIST		= 2204;
	
	// Cart Snapshot
	public static final int CART_SNAPSHOT_IS_NULL 						= 2250;	
	public static final int CART_SNAPSHOT_ALREADY_EXIST 				= 2251;
	public static final int CART_SNAPSHOT_NOT_FOUND 					= 2252;
	
	// Pay Partner-Store
	public static final int PAY_PARTNER_STORE_ALREADY_EXIST 			= 2300;
	public static final int PAY_PARTNER_STORE_NOT_FOUND 				= 2301;
	public static final int PAY_PARTNER_STORE_FLAGGED_AS_DELETED 		= 2302;	
	
	// Pay Partner-Country
	public static final int PAY_PARTNER_COUNTRY_ALREADY_EXIST 			= 2350;
	public static final int PAY_PARTNER_COUNTRY_NOT_FOUND 				= 2351;
	
	// Pay-Customer
	public static final int PAY_CUS_ALREADY_EXIST 						= 2400;
	public static final int PAY_CUS_NOT_FOUND 							= 2401;
	public static final int PAY_CUS_PERSON_CANT_BE_CHANGED				= 2402;
	public static final int PAY_CUS_PERSON_NOT_CHANGED					= 2403;
	public static final int PAY_CUS_TECH_FIELD_SHOULD_BE_EMPTY			= 2404;
	public static final int PAY_CUS_USER_ALREADY_EXIST					= 2405;
	public static final int PAY_CUS_USER_NOT_FOUND						= 2406;
	public static final int PAY_CUS_PHONE_IS_FILLED						= 2407;
	public static final int PAY_CUS_PHONE_IS_BLANK						= 2408;
	public static final int PAY_CUS_ADDRESS_IS_FILLED					= 2409;
	public static final int PAY_CUS_ADDRESS_IS_BLANK					= 2410;
	public static final int PAY_CUS_PAY_PARTNER_IS_FILLED				= 2411;
	public static final int PAY_CUS_PAY_PARTNER_IS_BLANK				= 2412;
	
	// Company
	public static final int COMPANY_TECH_FIELD_SHOULD_BE_EMPTY			= 2500;
	public static final int COMPANY_CNPJ_BLANK							= 2501;
	public static final int COMPANY_CNPJ_ALREADY_EXIST					= 2502;
	public static final int COMPANY_CNPJ_NOT_FOUND						= 2503;	
	public static final int COMPANY_ALREADY_EXIST 						= 2504;
	public static final int COMPANY_NOT_FOUND 							= 2505;
	public static final int COMPANY_CNPJ_INVALID_SEQUENCE				= 2506;
	public static final int COMPANY_CNPJ_INVALID_NUMBER					= 2507;
	public static final int COMPANY_CNPJ_INVALID						= 2508;
	public static final int COMPANY_CNPJ_CANT_BE_CHANGED				= 2509;
	public static final int COMPANY_CNPJ_NOT_CHANGED					= 2510;
	public static final int COMPANY_CNPJ_INVALID_LENGTH					= 2511;
	public static final int COMPANY_CNPJ_NO_ERASURE						= 2512;
	public static final int COMPANY_CNPJ_ERASURE						= 2513;
	public static final int COMPANY_IS_NULL								= 2514;
	public static final int COMPANY_IS_FILLED							= 2515;
	public static final int COMPANY_MISMATCH							= 2516;
	
	// Pay Partner-Owner
	public static final int PAY_PARTNER_OWNER_IS_NULL					= 2550;
	public static final int PAY_PARTNER_OWNER_IS_FILLED					= 2551;
	public static final int PAY_PARTNER_OWNER_ALREADY_EXIST 			= 2552;
	public static final int PAY_PARTNER_OWNER_NOT_FOUND 				= 2553;
	
	//User Password
	public static final int USER_PASSWORD_OR_USERNAME_IS_INVALID		= 2600;
	public static final int USER_PASSWORD_PERSON_IS_BLANK				= 2601;
	public static final int USER_PASSWORD_EMAIL_IS_BLANK				= 2602;
	
	// Employee Position
	public static final int EMPOS_ALREADY_EXIST 						= 2650;
	public static final int EMPOS_NOT_FOUND 							= 2651;
	public static final int EMPOS_FLAGGED_AS_DELETED 					= 2652;	
	public static final int EMPOS_HAS_ITEM								= 2653;
	public static final int EMPOS_NO_ITEM_FOUND							= 2654;
	
	// Owner-Store
	public static final int OWNER_STORE_IS_NULL							= 2700;
	public static final int OWNER_STORE_IS_FILLED						= 2701;
	public static final int OWNER_STORE_ALREADY_EXIST					= 2702;
	public static final int OWNER_STORE_NOT_FOUND						= 2703;
	
	// Username
	public static final int USERNAME_ALREADY_EXIST 						= 2750;
	public static final int USERNAME_NOT_FOUND 							= 2751;
	
	// Token
	public static final int TOKEN_IS_INVALID 							= 2800;
	public static final int TOKEN_IS_EXPIRED 							= 2801;
	
	// Store-Authorization
	public static final int STORE_AUTH_NOT_AUTHORIZED 					= 2850;
	
	// Store-Time
	public static final int STORE_TIME_IS_EMPTY							= 2900;
	public static final int STORE_TIME_IS_FILLED						= 2901;
	
	//Material Movement
	public static final int MAT_MOV_ALREADY_EXIST 						= 2950;
	public static final int MAT_MOV_NOT_FOUND 							= 2951;
	public static final int MAT_MOV_TECH_FIELD_SHOULD_BE_EMPTY			= 2952;
	public static final int MAT_MOV_MAT_CATEG_ILLEGAL					= 2953;
	public static final int MAT_MOV_TYPE_NOT_ALLOWED					= 2954;
	
	//Material Stock
	public static final int MAT_STOCK_ALREADY_EXIST 					= 3000;
	public static final int MAT_STOCK_NOT_FOUND 						= 3001;
	public static final int MAT_STOCK_NO_BALANCE 						= 3002;
	public static final int MAT_STOCK_LIMIT_EXCEEDED					= 3003;
	
	//Material Store
	public static final int MAT_STORE_PRICE_INCONSISTENCY				= 3050;
	public static final int MAT_STORE_MAT_CATEG_IS_NULL					= 3051;
	public static final int MAT_STORE_FLAGGED_AS_DELETED 				= 3052;
	public static final int MAT_STORE_ALREADY_EXIST 					= 3053;
	public static final int MAT_STORE_NOT_FOUND 						= 3054;
	public static final int MAT_STORE_STOCK_NOT_EMPTY					= 3055;
	
	//Order
	public static final int ORDER_HAVE_ITEM 							= 4000;
	public static final int ORDER_IS_EMPTY 								= 4001;	
	public static final int ORDER_ITEM_ALREADY_EXIST 					= 4002;
	public static final int ORDER_ITEM_NOT_FOUND 						= 4003;
	public static final int ORDER_STATUS_CHANGE_NOT_ALLOWED				= 4004;
}
