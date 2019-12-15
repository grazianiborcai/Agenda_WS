package br.com.mind5.common;

public final class SystemCode {
	// General
	public static final int MANDATORY_FIELD_EMPTY 						= 1;
	public static final int NO_ERROR_FOUND 								= 2;
	public static final int KEY_FIELD_NOT_NULL							= 5;
	public static final int KEY_FIELD_IS_EMPTY							= 6;
	public static final int BAD_TIME_RANGE								= 7;
	public static final int NO_CONFLICT									= 8;
	public static final int CONFLICT									= 9;
	public static final int DATA_NOT_FOUND								= 10;
	public static final int BAD_DATE									= 11;
	public static final int AGED_DATE									= 12;
	public static final int TECH_FIELD_SHOULD_BE_EMPTY					= 13;
	public static final int NO_ERROR_MESSAGE 							= 14;
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
	public static final int EMP_WTIME_MANDATORY_FIELD_EMPTY 			= 1009;
	public static final int EMP_WTIME_RANGE_OK 							= 1010;
	public static final int EMP_WTIME_CONFLICT_FOUND 					= 1011;
	public static final int EMP_WTIME_CONFLICT_FREE 					= 1012;
	
	// Employee
	public static final int EMP_ALREADY_EXIST 							= 1050;
	public static final int EMP_NOT_FOUND 								= 1051;
	public static final int EMP_FLAGGED_AS_DELETED 						= 1052;
	public static final int EMP_MULTIPLE_ENTRIES_FOUND					= 1053;
	public static final int EMP_SINGLE_ENTRY_FOUND						= 1054;
	public static final int EMP_CPF_ALREADY_EXIST						= 1055;
	public static final int EMP_CPF_NOT_FOUND							= 1056;	
	public static final int EMP_MANDATORY_FIELD_EMPTY					= 1057;
	public static final int EMP_ADDRESS_IS_NULL							= 1058;
	public static final int EMP_ADDRESS_IS_FILLED						= 1059;
	public static final int EMP_PERSON_IS_NULL							= 1060;
	public static final int EMP_PERSON_IS_FILLED						= 1061;
	public static final int EMP_PHONE_IS_NULL							= 1062;
	public static final int EMP_PHONE_IS_FILLED							= 1063;
	public static final int EMP_USER_IS_NULL							= 1064;
	public static final int EMP_USER_IS_FILLED							= 1065;
	public static final int EMP_ADDRESS_NUMBER_IS_NULL					= 1066;
	public static final int EMP_PHONE_NUMBER_IS_NULL					= 1067;
	
	// Store
	public static final int STORE_CNPJ_ALREADY_EXIST					= 1100;
	public static final int STORE_CNPJ_NOT_FOUND						= 1101;
	public static final int STORE_ALREADY_EXIST 						= 1102;
	public static final int STORE_NOT_FOUND 							= 1103;
	public static final int STORE_FEE_ALREADY_EXIST 					= 1123;
	public static final int STORE_FEE_NOT_FOUND 						= 1124;
	public static final int STORE_TECH_FIELD_SHOULD_BE_EMPTY			= 1125;
	public static final int STORE_HAS_ITEM 								= 1132;	
	public static final int STORE_NO_ITEM_FOUND 						= 1133;	
	public static final int STORE_MANDATORY_FIELD_EMPTY					= 1134;
	public static final int STORE_PHONE_IS_EMPTY						= 1135;
	public static final int STORE_ADDRESS_IS_EMPTY						= 1136;
	public static final int STORE_PERSON_IS_EMPTY						= 1137;
	public static final int STORE_PERSON_IS_FILLED						= 1138;
	public static final int STORE_COMPANY_IS_EMPTY						= 1139;
	public static final int STORE_COMPANY_IS_FILLED						= 1140;
	public static final int STORE_ADDRESS_IS_FILLED						= 1141;
	public static final int STORE_PHONE_IS_FILLED						= 1142;
	public static final int STORE_USER_IS_EMPTY							= 1143;
	public static final int STORE_USER_IS_FILLED						= 1144;
	
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
	public static final int SCHEDULE_STATUS_ALREADY_EXIST 				= 1196;
	public static final int SCHEDULE_STATUS_NOT_FOUND 					= 1197;
	public static final int WEEKDAY_MANDATORY_FIELD_EMPTY 				= 1198;
	public static final int USER_CATEG_MANDATORY_FIELD_EMPTY 			= 1199;
	public static final int TIMEZONE_MANDATORY_FIELD_EMPTY 				= 5300;
	public static final int STATE_MANDATORY_FIELD_EMPTY 				= 5301;
	public static final int SCHEDULE_STATUS_MANDATORY_FIELD_EMPTY 		= 5302;
	public static final int POSITION_MANDATORY_FIELD_EMPTY 				= 5303;
	public static final int PAY_PARTNER_MANDATORY_FIELD_EMPTY 			= 5304;
	public static final int PAYMENT_STATUS_MANDATORY_FIELD_EMPTY 		= 5305;
	public static final int ORDER_STATUS_MANDATORY_FIELD_EMPTY 			= 5306;
	public static final int UNIT_MANDATORY_FIELD_EMPTY 					= 5307;
	public static final int MAT_TYPE_MANDATORY_FIELD_EMPTY 				= 5308;
	public static final int MAT_MOV_TYPE_MANDATORY_FIELD_EMPTY 			= 5309;
	public static final int MAT_GROUP_MANDATORY_FIELD_EMPTY 			= 5310;
	public static final int MAT_CATEG_MANDATORY_FIELD_EMPTY 			= 5311;
	public static final int GENDER_MANDATORY_FIELD_EMPTY 				= 5312;
	public static final int FEE_CATEG_MANDATORY_FIELD_EMPTY 			= 5313;
	public static final int ENTITY_CATEG_MANDATORY_FIELD_EMPTY 			= 5314;
	public static final int CURRENCY_MANDATORY_FIELD_EMPTY 				= 5315;
	public static final int COUNTRY_PHONE_MANDATORY_FIELD_EMPTY 		= 5316;
	public static final int COUNTRY_LEGAL_MANDATORY_FIELD_EMPTY 		= 5317;
	public static final int COUNTRY_MANDATORY_FIELD_EMPTY 				= 5318;
	public static final int CART_CATEG_MANDATORY_FIELD_EMPTY 			= 5319;
	public static final int BUSINESS_MANDATORY_FIELD_EMPTY 				= 5320;
	public static final int AUTH_ROLE_MANDATORY_FIELD_EMPTY 			= 5321;
	public static final int AUTH_GROUP_MANDATORY_FIELD_EMPTY 			= 5322;
	public static final int AREA_PHONE_MANDATORY_FIELD_EMPTY 			= 5323;
	public static final int MONTH_ALREADY_EXIST							= 5324;
	public static final int MONTH_NOT_FOUND								= 5325;
	public static final int POSITION_ALREADY_EXIST						= 5326;
	public static final int POSITION_NOT_FOUND							= 5327;
	
	// Material
	public static final int MAT_ALREADY_EXIST							= 1200;
	public static final int MAT_NOT_FOUND								= 1201;
	public static final int MAT_SERVICE									= 1204;
	public static final int MAT_NOT_SERVICE								= 1205;
	public static final int MAT_UNIT_EACH_INCONSISTENCY					= 1206;
	public static final int MAT_UNIT_INCONSISTENCY						= 1207;
	public static final int MAT_CATEG_CANT_BE_CHANGED					= 1208;	
	public static final int MAT_CATEG_NOT_CHANGED						= 1209;		
	public static final int MAT_TEXT_HAS_NO_DEFAULT						= 1211;
	public static final int MAT_TEXT_HAS_DEFAULT						= 1212;
	public static final int MAT_TEXT_DEFAULT_CANT_BE_DELETED			= 1213;
	public static final int MAT_HAS_ITEM								= 1214;
	public static final int MAT_NO_ITEM_FOUND							= 1215;
	public static final int MAT_MANDATORY_FIELD_EMPTY 					= 1216;
	public static final int MAT_SERVICE_UNIT_INCONSISTENCY				= 1217;
	public static final int MAT_PRODUCT									= 1218;
	public static final int MAT_NOT_PRODUCT								= 1219;
	public static final int MAT_PRODUCT_UNIT_INCONSISTENCY				= 1220;
	public static final int MAT_PRICE_UNIT_LOWER_THAN_MIN				= 1221;
	
	// Owner
	public static final int OWNER_ALREADY_EXIST							= 1250;
	public static final int OWNER_NOT_FOUND								= 1251;
	public static final int OWNER_TECH_FIELD_SHOULD_BE_EMPTY_			= 1252;
	public static final int OWNER_PERSON_NOT_CHANGED					= 1253;
	public static final int OWNER_PERSON_CANT_BE_CHANGED				= 1254;
	public static final int OWNER_MANDATORY_FIELD_EMPTY 				= 1255;
	public static final int OWNER_PERSON_IS_EMPTY 						= 1256;
	public static final int OWNER_PERSON_IS_FILLED 						= 1257;
	public static final int OWNER_COMPANY_IS_EMPTY 						= 1258;
	public static final int OWNER_COMPANY_IS_FILLED 					= 1259;
	public static final int OWNER_ADDRESS_IS_EMPTY 						= 1260;
	public static final int OWNER_ADDRESS_IS_FILLED 					= 1261;
	public static final int OWNER_PHONE_IS_EMPTY 						= 1262;
	public static final int OWNER_PHONE_IS_FILLED 						= 1263;
	
	// Employee Leave Date
	public static final int EMP_LDATE_ALREADY_EXIST 					= 1300;
	public static final int EMP_LDATE_NOT_FOUND 						= 1301;
	public static final int EMP_LDATE_FLAGGED_AS_DELETED 				= 1302;
	public static final int EMP_LDATE_NO_LEAVE_FOUND					= 1303;
	public static final int EMP_LDATE_LEAVE_FOUND						= 1304;
	public static final int EMP_LDATE_MANDATORY_FIELD_EMPTY				= 1305;
	public static final int EMP_LDATE_BAD_TIME_RANGE 					= 1306;
	public static final int EMP_LDATE_SCHEDULE_CONFLICT 				= 1307;
	
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
	public static final int CUS_MANDATORY_FIELD_EMPTY					= 1367;
	
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
	public static final int CART_HEADER_MANDATORY_FIELD_EMPTY			= 1411;
	public static final int CART_ITEM_MANDATORY_FIELD_EMPTY				= 1412;
	
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
	public static final int PHONE_MANDATORY_FIELD_EMPTY 				= 1575;	
	public static final int PHONE_LIMIT_NOT_REACHED						= 1576;
	public static final int PHONE_FORM_INVALID							= 1577;
	public static final int PHONE_FORM_OK								= 1578;
	
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
	public static final int ADDRESS_MANDATORY_FIELD_EMPTY				= 1614;
	public static final int ADDRESS_LIMIT_NOT_REACHED					= 1615;
	public static final int ADDRESS_HAS_STATE							= 1616;
	public static final int ADDRESS_HAS_NO_STATE						= 1617;
	
	// Form
	public static final int FORM_ADDRESS_ALREADY_EXIST					= 1700;
	public static final int FORM_ADDRESS_NOT_FOUND						= 1701;
	public static final int FORM_ADDRESS_INVALID						= 1702;
	public static final int FORM_PHONE_INVALID							= 1703;
	public static final int FORM_ADDRESS_OK								= 1704;
	
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
	public static final int PERSON_MANDATORY_FIELD_EMPTY				= 1776;
	public static final int PERSON_IS_BLANK								= 1777;
	
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
	public static final int USER_MANDATORY_FIELD_EMPTY					= 1810;
	
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
	public static final int ADDRESS_SNAPSHOT_HAS_STATE					= 2004;
	public static final int ADDRESS_SNAPSHOT_HAS_NO_STATE				= 2005;
	
	// Phone Snapshot
	public static final int PHONE_SNAPSHOT_IS_NULL 						= 2050;	
	public static final int PHONE_SNAPSHOT_IS_FILLED 					= 2051;	
	public static final int PHONE_SNAPSHOT_NOT_FOUND					= 2052;
	public static final int PHONE_SNAPSHOT_ALREADY_EXIST				= 2053;
	public static final int PHONE_SNAPSHOT_MANDATORY_FIELD_EMPTY		= 2054;
	public static final int PHONE_SNAPSHOT_USER_IS_FILLED				= 2055;
	public static final int PHONE_SNAPSHOT_USER_IS_EMPTY				= 2056;
	public static final int PHONE_SNAPSHOT_EMPLOYEE_IS_FILLED			= 2057;
	public static final int PHONE_SNAPSHOT_EMPLOYEE_IS_EMPTY			= 2058;
	public static final int PHONE_SNAPSHOT_CUSTOMER_IS_FILLED			= 2059;
	public static final int PHONE_SNAPSHOT_CUSTOMER_IS_EMPTY			= 2060;
	public static final int PHONE_SNAPSHOT_STORE_IS_FILLED				= 2061;
	public static final int PHONE_SNAPSHOT_STORE_IS_EMPTY				= 2062;
	
	// Person Snapshot
	public static final int PERSON_SNAPSHOT_IS_NULL 					= 6200;
	public static final int PERSON_SNAPSHOT_NOT_FOUND					= 6201;
	public static final int PERSON_SNAPSHOT_ALREADY_EXIST				= 6202;
	
	// PersonCustomer
	public static final int PERSON_CUS_WITHOUT_REFERENCE				= 2100;
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
	public static final int PAY_PARTNER_STORE_MANDATORY_FIELD_EMPTY 	= 2303;
	
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
	public static final int PAY_CUS_PAY_PARTNER_NOT_FOUND				= 2413;
	public static final int PAY_CUS_ADDRESS_DIF_USER					= 2414;
	public static final int PAY_CUS_PHONE_DIF_USER						= 2415;
	public static final int PAY_CUS_MANDATORY_FIELD_EMPTY 				= 2416;
	
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
	public static final int COMPANY_MANDATORY_FIELD_EMPTY 				= 2517;
	
	// Pay Partner-Owner
	public static final int PAY_PARTNER_OWNER_IS_NULL					= 2550;
	public static final int PAY_PARTNER_OWNER_IS_FILLED					= 2551;
	public static final int PAY_PARTNER_OWNER_ALREADY_EXIST 			= 2552;
	public static final int PAY_PARTNER_OWNER_NOT_FOUND 				= 2553;
	
	//User Password
	public static final int USER_PASSWORD_OR_USERNAME_IS_INVALID		= 2600;
	public static final int USER_PASSWORD_PERSON_IS_BLANK				= 2601;
	public static final int USER_PASSWORD_EMAIL_IS_BLANK				= 2602;
	public static final int USER_PASSWORD_MANDATORY_FIELD_EMPTY			= 2603;
	public static final int USER_PASSWORD_IS_NOT_PWD_ENABLED			= 2604;
	
	// Employee Position
	public static final int EMPOS_ALREADY_EXIST 						= 2650;
	public static final int EMPOS_NOT_FOUND 							= 2651;
	public static final int EMPOS_FLAGGED_AS_DELETED 					= 2652;	
	public static final int EMPOS_HAS_ITEM								= 2653;
	public static final int EMPOS_NO_ITEM_FOUND							= 2654;
	public static final int EMPOS_MANDATORY_FIELD_EMPTY					= 2655;
	public static final int EMPOS_HAS_SCHEDULE							= 2656;
	public static final int EMPOS_NO_SCHEDULE_FOUND						= 2657;
	public static final int EMPOS_HAS_LDATE								= 2658;
	public static final int EMPOS_NO_LDATE_FOUND						= 2659;
	
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
	public static final int STORE_AUTH_MANDATORY_FIELD_EMPTY 			= 2851;
	
	// Store-Time
	public static final int STORE_TIME_IS_EMPTY							= 2900;
	public static final int STORE_TIME_IS_FILLED						= 2901;
	
	//Material Movement
	public static final int MAT_MOV_ALREADY_EXIST 						= 2950;
	public static final int MAT_MOV_NOT_FOUND 							= 2951;
	public static final int MAT_MOV_TECH_FIELD_SHOULD_BE_EMPTY			= 2952;
	public static final int MAT_MOV_MAT_CATEG_ILLEGAL					= 2953;
	public static final int MAT_MOV_TYPE_NOT_ALLOWED					= 2954;
	public static final int MAT_MOV_MANDATORY_FIELD_EMPTY				= 2955;
	
	//Material Stock
	public static final int MAT_STOCK_ALREADY_EXIST 					= 3000;
	public static final int MAT_STOCK_NOT_FOUND 						= 3001;
	public static final int MAT_STOCK_NO_BALANCE 						= 3002;
	public static final int MAT_STOCK_LIMIT_EXCEEDED					= 3003;
	public static final int MAT_STOCK_MANDATORY_FIELD_EMPTY				= 3004;
	
	//Material Store
	public static final int MAT_STORE_PRICE_INCONSISTENCY				= 3050;
	public static final int MAT_STORE_MAT_CATEG_IS_NULL					= 3051;
	public static final int MAT_STORE_FLAGGED_AS_DELETED 				= 3052;
	public static final int MAT_STORE_ALREADY_EXIST 					= 3053;
	public static final int MAT_STORE_NOT_FOUND 						= 3054;
	public static final int MAT_STORE_STOCK_NOT_EMPTY					= 3055;
	public static final int MAT_STORE_MANDATORY_FIELD_EMPTY				= 3056;
	public static final int MAT_STORE_IS_SERVICE						= 3057;
	public static final int MAT_STORE_IS_NOT_SERVICE					= 3058;
	public static final int MAT_STORE_IS_PRODUCT						= 3059;
	public static final int MAT_STORE_IS_NOT_PRODUCT					= 3040;
	
	//Order
	public static final int ORDER_HAVE_ITEM 							= 4000;
	public static final int ORDER_IS_EMPTY 								= 4001;	
	public static final int ORDER_ITEM_ALREADY_EXIST 					= 4002;
	public static final int ORDER_ITEM_NOT_FOUND 						= 4003;
	public static final int ORDER_STATUS_CHANGE_NOT_ALLOWED				= 4004;
	public static final int ORDER_ALREADY_EXIST							= 4005;
	public static final int ORDER_NOT_FOUND								= 4006;
	public static final int ORDER_HEADER_MANDATORY_FIELD_EMPTY			= 4007;
	public static final int ORDER_DONT_HAVE_PAYMENT						= 4008;
	public static final int ORDER_ITEM_IS_NOT_SERVICE 					= 4009;
	public static final int ORDER_ITEM_MANDATORY_FIELD_EMPTY			= 4010;
	
	//Pay-Order
	public static final int PAY_ORDER_PAYMENT_ALREADY_EXIST				= 4050;
	public static final int PAY_ORDER_DIF_ORDER_USER					= 4051;
	public static final int PAY_ORDER_ADDRESS_DIF_USER					= 4052;
	public static final int PAY_ORDER_PHONE_DIF_USER					= 4053;
	public static final int PAY_ORDER_ITEM_MANDATORY_FIELD_EMPTY		= 4054;
	public static final int PAY_ORDER_ITEM_ALREADY_EXIST 				= 4055;
	public static final int PAY_ORDER_ITEM_NOT_FOUND 					= 4056;
	public static final int PAY_ORDER_HAVE_ITEM 						= 4057;
	public static final int PAY_ORDER_IS_EMPTY 							= 4058;	
	public static final int PAY_ORDER_HEADER_MANDATORY_FIELD_EMPTY		= 4059;	
	public static final int PAY_ORDER_DIF_CUSPAR_USER					= 4060;
	public static final int PAY_ORDER_ALREADY_EXIST 					= 4061;
	public static final int PAY_ORDER_NOT_FOUND 						= 4062;
	public static final int PAY_ORDER_ITEM_IS_FEE 						= 4063;
	public static final int PAY_ORDER_ITEM_IS_NOT_FEE 					= 4064;
	
	// Pay-Customer-Moip
	public static final int PAY_CUS_MOIP_CREATION_ERROR 				= 4100;
	public static final int PAY_CUS_MOIP_SETUPAR_MISSING				= 4101;
	public static final int PAY_CUS_MOIP_USERAP_MISSING					= 4102;
	public static final int PAY_CUS_MOIP_PHONAP_MISSING					= 4103;
	public static final int PAY_CUS_MOIP_ADDRESNAP_MISSING				= 4104;
	public static final int PAY_CUS_MOIP_MANDATORY_FIELD_EMPTY 			= 4105;
	public static final int PAY_CUS_MOIP_PHONE_BR						= 4106;
	public static final int PAY_CUS_MOIP_ADDRESS_BR						= 4107;
	public static final int PAY_CUS_MOIP_DELETION_ERROR 				= 4108;
	
	// Credit Card
	public static final int CREDIT_CARD_INVALID_USER_REF				= 4150;
	public static final int CREDIT_CARD_MANDATORY_FIELD_EMPTY 			= 4151;
	public static final int CREDIT_CARD_EMPTY_CUSPAR					= 4152;
	public static final int CREDIT_CARD_EMPTY_PAYPAR					= 4153;
	public static final int CREDIT_CARD_ALREADY_EXIST					= 4154;
	public static final int CREDIT_CARD_NOT_FOUND						= 4155;
	
	// Credit Card-Moip
	public static final int CREDIT_CARD_MOIP_ADDRESS_BR					= 4200;
	public static final int CREDIT_CARD_MOIP_ADDRESS_MISSING			= 4201;
	public static final int CREDIT_CARD_MOIP_EMPTY_CUSPAR				= 4202;
	public static final int CREDIT_CARD_MOIP_PHONE_MISSING				= 4203;
	public static final int CREDIT_CARD_MOIP_PHONE_BR					= 4204;
	public static final int CREDIT_CARD_MOIP_MANDATORY_FIELD_EMPTY		= 4205;
	public static final int CREDIT_CARD_PAYPAR_NOT_MOIP					= 4206;
	public static final int CREDIT_CARD_MOIP_CREATION_ERROR				= 4207;
	public static final int CREDIT_CARD_MOIP_DELETION_ERROR				= 4208;
	public static final int CREDIT_CARD_MOIP_MISSING_BIRTHDATE			= 4209;
	
	// System Pay Partner
	public static final int SYS_PAY_PARTNER_MANDATORY_FIELD_EMPTY		= 4250;
	public static final int SYS_PAY_PARTNER_ALREADY_EXIST 				= 4251;
	public static final int SYS_PAY_PARTNER_NOT_FOUND 					= 4252;
	
	// Access Moip
	public static final int ACCESS_MOIP_MANDATORY_FIELD_EMPTY			= 4300;
	
	// Pay Partner Setup
	public static final int PAY_PARTNER_SETUP_MANDATORY_FIELD_EMPTY 	= 4350;
	public static final int PAY_PARTNER_SETUP_ALREADY_EXIST 			= 4351;
	public static final int PAY_PARTNER_SETUP_NOT_FOUND 				= 4352;
	
	// Moip Permission Response
	public static final int MOIP_PERM_RESP_MANDATORY_FIELD_EMPTY 		= 4400;
	public static final int MOIP_PERM_RESP_ALREADY_EXIST 				= 4401;
	public static final int MOIP_PERM_RESP_NOT_FOUND 					= 4402;
	public static final int MOIP_PERM_RESP_IS_NOT_EXPECTED				= 4403;
	
	// Order Moip
	public static final int ORDER_MOIP_MANDATORY_FIELD_EMPTY			= 4450;
	public static final int ORDER_MOIP_ITEM_IS_FEE 						= 4451;
	public static final int ORDER_MOIP_ITEM_IS_NOT_FEE 					= 4452;
	public static final int ORDER_MOIP_CREATION_ERROR					= 4453;
	public static final int ORDER_MOIP_READ_ERROR						= 4454;
	
	// Multi-Order Moip
	public static final int MULT_MOIP_MANDATORY_FIELD_EMPTY				= 4500;
	public static final int MULT_MOIP_READ_ERROR						= 4501;
	
	// Pay-Order Moip
	public static final int PAY_MOIP_MANDATORY_FIELD_EMPTY 				= 4550;
	public static final int PAY_MOIP_CREATION_ERROR						= 4551;
	public static final int PAY_MOIP_READ_ERROR							= 4552;
	
	// Pay-Order Status
	public static final int PAY_STATUS_ITEM_MANDATORY_FIELD_EMPTY		= 4600;
	public static final int PAY_STATUS_NOT_CHANGEABLE					= 4601;
	public static final int PAY_STATUS_HEADER_MANDATORY_FIELD_EMPTY		= 4602;
	
	// Refund Moip
	public static final int REFUND_MOIP_REFUND_ERROR 					= 4650;
	public static final int REFUND_MOIP_MANDATORY_FIELD_EMPTY			= 4651;
	public static final int REFUND_MOIP_IS_NOT_SYSTEM_RECEIVER			= 4652;
	
	// Refund
	public static final int REFUND_ITEM_MANDATORY_FIELD_EMPTY			= 4700;
	public static final int REFUND_HEADER_MANDATORY_FIELD_EMPTY			= 4701;
	
	// Webhook - Pay-Moip
	public static final int WHOOK_MOIP_PAY_MANDATORY_FIELD_EMPTY 		= 4750;
	
	// Schedule
	public static final int SCHEDULE_MANDATORY_FIELD_EMPTY				= 4800;
	public static final int SCHEDULE_HAS_NO_ORDER						= 4801;
	public static final int SCHEDULE_MATERIAL_IS_NOT_SERVICE			= 4802;	
	public static final int SCHEDULE_ALREADY_EXIST						= 4803;
	public static final int SCHEDULE_NOT_FOUND							= 4804;
	public static final int SCHEDULE_NOT_CANCELLED						= 4805;
	public static final int SCHEDULE_ALREADY_TAKEN						= 4806;
	public static final int SCHEDULE_NOT_TAKEN							= 4807;
	
	// Store Snapshot
	public static final int STORE_SNAPSHOT_MANDATORY_FIELD_EMPTY 		= 4850;
	
	// Company Snpshot
	public static final int COMPANY_SNAP_MANDATORY_FIELD_EMPTY 			= 4900;
	
	// Employee List
	public static final int EMP_LIST_MANDATORY_FIELD_EMPTY				= 4950;
	
	// Store List
	public static final int STORE_LIST_MANDATORY_FIELD_EMPTY 			= 5000;
	
	// Customer Snapshot
	public static final int CUS_SNAPSHOT_MANDATORY_FIELD_EMPTY			= 5050;
	
	// Customer List
	public static final int CUS_LIST_MANDATORY_FIELD_EMPTY 				= 5100;
	
	// User List
	public static final int USER_LIST_MANDATORY_FIELD_EMPTY				= 5150;
	
	// Schedule-Snapshot
	public static final int SCHEDULE_SNAPSHOT_MANDATORY_FIELD_EMPTY		= 5200;
	public static final int SCHEDULE_SNAPSHOT_HAS_NO_ORDER				= 5201;
	
	// Customer Search
	public static final int CUSTOMER_SEARCH_MANDATORY_FIELD_EMPTY 		= 5250;
	
	// Order Search
	public static final int ORDER_SEARCH_MANDATORY_FIELD_EMPTY 			= 5351;
	
	// Order List
	public static final int ORDER_LIST_MANDATORY_FIELD_EMPTY 			= 5400;
	
	// Schedule Search
	public static final int SCHEDULE_SEARCH_MANDATORY_FIELD_EMPTY		= 5450;
	
	// Order Snapshot
	public static final int ORDER_HEADER_SNAP_MANDATORY_FIELD_EMPTY		= 5500;
	public static final int ORDER_ITEM_SNAP_MANDATORY_FIELD_EMPTY		= 5501;
	public static final int ORDER_HEADER_SNAP_ALREADY_EXIST				= 5502;
	public static final int ORDER_HEADER_SNAP_NOT_FOUND					= 5503;
	
	// Pay Order Search
	public static final int PAY_ORDER_SEARCH_MANDATORY_FIELD_EMPTY		= 5550;	
	
	// Schedule List
	public static final int SCHEDULE_LIST_MANDATORY_FIELD_EMPTY			= 5600;
	
	// Schedule Moviment
	public static final int SCHEDULE_MOV_MANDATORY_FIELD_EMPTY			= 5650;
	
	// Schedule Year Data
	public static final int SCHEDULE_YEAR_DATA_FIELD_EMPTY				= 5700;
	
	// Schedule Year
	public static final int SCHEDULE_YEAR_FIELD_EMPTY					= 5750;
	
	// Schedule Month Data
	public static final int SCHEDULE_MONTH_DATA_FIELD_EMPTY				= 5800;
	
	// Schedule Month
	public static final int SCHEDULE_MONTH_FIELD_EMPTY					= 5850;
	
	// Schedule Week Data
	public static final int SCHEDULE_WEEK_DATA_FIELD_EMPTY				= 5900;
	
	// Schedule Week
	public static final int SCHEDULE_WEEK_FIELD_EMPTY					= 5950;
	
	// File Image
	public static final int FILE_IMG_MANDATORY_FIELD_EMPTY 				= 6001;
	public static final int FILE_IMG_ALREADY_EXIST						= 6002;
	public static final int FILE_IMG_NOT_FOUND							= 6003;
	public static final int FILE_IMG_LIMIT_NOT_REACHED					= 6004;
	public static final int FILE_IMG_LIMIT_EXCEEDED						= 6005;
	public static final int FILE_IMG_IS_NOT_STORE						= 6006;
	public static final int FILE_IMG_IS_NOT_OWNER						= 6007;
	public static final int FILE_IMG_ILLEGAL_REFERENCE 					= 6008;
	public static final int FILE_IMG_IS_NOT_EMPLOYEE					= 6009;
	public static final int FILE_IMG_IS_NOT_MAT							= 6010;
	
	// File Path
	public static final int FILE_PATH_MANDATORY_FIELD_EMPTY 			= 6051;
	
	// File Write
	public static final int FILE_WRITE_MANDATORY_FIELD_EMPTY 			= 6101;
	public static final int FILE_WRITE_ERROR 							= 6102;
	
	// Employee Snapshot
	public static final int EMP_SNAP_ALREADY_EXIST 						= 6150;
	public static final int EMP_SNAP_NOT_FOUND 							= 6151;
	public static final int EMP_SNAP_MANDATORY_FIELD_EMPTY				= 6152;
	
	// System
	public static final int AUTO_GENERATED_FIELD_IS_NOT_EMPTY			= 6250;
	
	//System Message
	public static final int SYS_MESSAGE_ALREADY_EXIST 					= 6300;
	public static final int SYS_MESSAGE_NOT_FOUND 						= 6301;
	public static final int SYS_MESSAGE_MANDATORY_FIELD_EMPTY			= 6302;
	public static final int SYS_MESSAGE_IS_ENGLISH						= 6303;
	public static final int SYS_MESSAGE_IS_NOT_ENGLISH					= 6304;
	
	//Owner Snapshot
	public static final int OWNER_SNAP_MANDATORY_FIELD_EMPTY 			= 6350;
	
	//Company List
	public static final int COMPANY_LIST_MANDATORY_FIELD_EMPTY 			= 6400;
	
	//Address Snapshot
	public static final int ADDRESS_SNAP_MANDATORY_FIELD_EMPTY			= 6450;
	public static final int ADDRESS_SNAP_USER_IS_FILLED					= 6451;
	public static final int ADDRESS_SNAP_USER_IS_EMPTY					= 6452;
	public static final int ADDRESS_SNAP_EMPLOYEE_IS_FILLED				= 6453;
	public static final int ADDRESS_SNAP_EMPLOYEE_IS_EMPTY				= 6454;
	public static final int ADDRESS_SNAP_CUSTOMER_IS_FILLED				= 6455;
	public static final int ADDRESS_SNAP_CUSTOMER_IS_EMPTY				= 6456;
	public static final int ADDRESS_SNAP_STORE_IS_FILLED				= 6457;
	public static final int ADDRESS_SNAP_STORE_IS_EMPTY					= 6458;
	
	//Address Search
	public static final int ADDRESS_SEARCH_MANDATORY_FIELD_EMPTY		= 6500;
	
	//Phone Search
	public static final int PHONE_SEARCH_MANDATORY_FIELD_EMPTY 			= 6550;	
	
	// Store Search
	public static final int STORE_SEARCH_MANDATORY_FIELD_EMPTY 			= 6600;
	
	//Comapny Search
	public static final int COMPANY_SEARCH_MANDATORY_FIELD_EMPTY 		= 6650;
	
	//Person Search
	public static final int PERSON_SEARCH_MANDATORY_FIELD_EMPTY			= 6700;
	
	// File Image Search
	public static final int FILE_IMG_SEARCH_MANDATORY_FIELD_EMPTY 		= 6750;
	
	// File Image List
	public static final int FILE_IMG_LIST_MANDATORY_FIELD_EMPTY 		= 6800;
	
	// Store Work Time
	public static final int STORE_WTIME_NOT_FOUND 						= 6850; //1110;
	public static final int STORE_WTIME_ALREADY_EXIST					= 6851; //1111;
	public static final int STORE_WTIME_FLAGGED_AS_DELETED 				= 6852; //1112;	
	public static final int STORE_WTIME_VALID_WORKHOUR					= 6853; //1116;
	public static final int STORE_WTIME_WORKHOUR_OUT_OF_RANGE			= 6854; //1117;
	public static final int STORE_WTIME_NO_LEAVE_FOUND					= 6855; //1121;
	public static final int STORE_WTIME_LEAVE_FOUND						= 6856; //1122;
	public static final int STORE_WTIME_FLAG_DELETE_TRUE				= 6857; //1126;
	public static final int STORE_WTIME_FLAG_DELETE_FALSE				= 6858; //1127;
	public static final int STORE_WTIME_HAVE_ITEM 						= 6859; //1128;
	public static final int STORE_WTIME_IS_EMPTY 						= 6860; //1129;	
	public static final int STORE_WTIME_MANDATORY_FIELD_EMPTY 			= 6861;
	public static final int STORE_WTIME_BAD_TIME_RANGE 					= 6862;
	public static final int STORE_WTIME_HAS_EMPLOYEE 					= 6863;
	public static final int STORE_WTIME_EMPLOYEE_NOT_FOUND 				= 6864;
	
	
	//Employee Work Time Outlier
	public static final int EMP_WT_OUT_MANDATORY_FIELD_EMPTY 			= 6900;
	public static final int EMP_WT_OUT_NOT_FOUND						= 6901;
	public static final int EMP_WT_OUT_ALREADY_EXIST					= 6902;
	
	//Store Leave Date
	public static final int STORE_LDATE_MANDATORY_FIELD_EMPTY 			= 6950;
	public static final int STORE_LDATE_NOT_FOUND 						= 6951; //1113;
	public static final int STORE_LDATE_ALREADY_EXIST					= 6952; //1114;
	public static final int STORE_LDATE_FLAGGED_AS_DELETED 				= 6953; //1115;	
	public static final int STORE_LDATE_HAVE_ITEM 						= 6954; //1130;
	public static final int STORE_LDATE_IS_EMPTY 						= 6955; //1131;	
	public static final int STORE_LDATE_BAD_TIME_RANGE 					= 6956;
	public static final int STORE_LDATE_SCHEDULE_CONFLICT 				= 6957;
	
	//Store Leave Date - Search
	public static final int STORE_LDATE_SEARCH_MANDATORY_FIELD_EMPTY 	= 7000;
	
	// Schedule Outlier
	public static final int SCHEDULE_OUTLIER_MANDATORY_FIELD_EMPTY		= 7050;
	
	// Token Moip
	public static final int TOKEN_MOIP_MANDATORY_FIELD_EMPTY			= 7100;
	
	// Employee Position Search
	public static final int EMPOS_SEARCH_MANDATORY_FIELD_EMPTY			= 7150;
	public static final int EMPOS_SEARCH_NOT_FOUND 						= 7151;
	public static final int EMPOS_SEARCH_ALREADY_EXIST 					= 7152;	
	
	// Store Worktime Range
	public static final int STORE_WTIME_RANGE_MANDATORY_FIELD_EMPTY 	= 7200;
	
	// Store Worktime Search
	public static final int STORE_WTIME_SEARCH_MANDATORY_FIELD_EMPTY 	= 7250;
	public static final int STORE_WTIME_SEARCH_ALREADY_EXIST 			= 7251;
	public static final int STORE_WTIME_SEARCH_NOT_FOUND 				= 7252;
	
	// Employee Worktime Search
	public static final int EMP_WTIME_SEARCH_MANDATORY_FIELD_EMPTY 		= 7300;
	public static final int EMP_WTIME_SEARCH_ALREADY_EXIST 				= 7301;
	public static final int EMP_WTIME_SEARCH_NOT_FOUND 					= 7302;
	
	// Employee Worktime Conflict
	public static final int EMP_WTIME_CONFLICT_MANDATORY_FIELD_EMPTY 	= 7350;
	
	// Employee Leave Date Search
	public static final int EMP_LDATE_SEARCH_MANDATORY_FIELD_EMPTY 		= 7400;
	public static final int EMP_LDATE_SEARCH_ALREADY_EXIST 				= 7401;
	public static final int EMP_LDATE_SEARCH_NOT_FOUND 					= 7402;
	
	// Employee Search
	public static final int EMP_SEARCH_MANDATORY_FIELD_EMPTY			= 7450;
	
	// Person List
	public static final int PERSON_LIST_MANDATORY_FIELD_EMPTY			= 7500;
	public static final int PERSON_LIST_ALREADY_EXIST 					= 7501;
	public static final int PERSON_LIST_NOT_FOUND 						= 7502;
	
	// Employee-Material
	public static final int EMP_MAT_ALREADY_EXIST 						= 7550; //1107;
	public static final int EMP_MAT_NOT_FOUND 							= 7551; //1108;
	public static final int EMP_MAT_FLAGGED_AS_DELETED 					= 7552; //1109;	
	public static final int EMP_MAT_MANDATORY_FIELD_EMPTY				= 7553;
	
	// Employee-Material Search
	public static final int EMP_MAT_SEARCH_MANDATORY_FIELD_EMPTY		= 7600;
	public static final int EMP_MAT_SEARCH_ALREADY_EXIST 				= 7601; 
	public static final int EMP_MAT_SEARCH_NOT_FOUND 					= 7602; 
	
	// Material Text Search
	public static final int MAT_TEXT_SEARCH_MANDATORY_FIELD_EMPTY		= 7650;
	public static final int MAT_TEXT_SEARCH_ALREADY_EXIST				= 7651;
	public static final int MAT_TEXT_SEARCH_NOT_FOUND					= 7652;
	
	// Material Text Default
	public static final int MAT_TEXT_DEFAULT_MANDATORY_FIELD_EMPTY		= 7700;
	public static final int MAT_TEXT_DEFAULT_ALREADY_EXIST 				= 7701;
	public static final int MAT_TEXT_DEFAULT_NOT_FOUND 					= 7702;
	
	// Material List
	public static final int MAT_LIST_MANDATORY_FIELD_EMPTY				= 7750;
	
	// Material Text
	public static final int MAT_TEXT_MANDATORY_FIELD_EMPTY				= 7800;
	public static final int MAT_TEXT_NOT_DEFAULT						= 7801;	//1210;
	public static final int MAT_TEXT_FLAGGED_AS_DELETED 				= 7803;	
	public static final int MAT_TEXT_NOT_FLAGGED_AS_DELETED 			= 7804;	
	public static final int MAT_TEXT_ALREADY_EXIST						= 7805;	//1202;
	public static final int MAT_TEXT_NOT_FOUND							= 7806;	//1203;	
	public static final int MAT_TEXT_DONT_HAVE_MAT						= 7807;
	
	// Material Text Snapshot
	public static final int MAT_TEXT_SNAPSHOT_MANDATORY_FIELD_EMPTY		= 7850;
	
	// Material Snapshot
	public static final int MAT_SNAPSHOT_MANDATORY_FIELD_EMPTY			= 7900;
	
	// Material Search
	public static final int MAT_SEARCH_MANDATORY_FIELD_EMPTY			= 7950;
	public static final int MAT_SEARCH_SERVICE_ALREADY_EXIST			= 7951;
	public static final int MAT_SEARCH_SERVICE_NOT_FOUND				= 7952;
	public static final int MAT_SEARCH_PRODUCT_ALREADY_EXIST			= 7953;
	public static final int MAT_SEARCH_PRODUCT_NOT_FOUND				= 7954;
	
	// Material Store Search
	public static final int MAT_STORE_SEARCH_MANDATORY_FIELD_EMPTY		= 8000;
	
	//Material Store Snapshot
	public static final int MAT_STORE_SNAPSHOT_MANDATORY_FIELD_EMPTY	= 8050;
}
