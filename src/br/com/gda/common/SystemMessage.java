package br.com.gda.common;

public final class SystemMessage {
	public static final String CPF_INVALID = "CPF is invalid";
	public static final String CNPJ_INVALID = "CNPJ is invalid";	
	public static final String OWNER_NOT_FOUND = "Owner data not found on DB";
	public static final String NULL_TABLE_NAME = "Table name is null";
	public static final String TABLE_NOT_FOUND = "table was not found";			
	public static final String ILLEGAL_ARGUMENT = "IllegalArgument: mandatory argument might be missing or invalid value was passed";	
	public static final String NULL_WHERE_CLAUSE = "where clause is null";			
	public static final String OWNER_ALREALDY_EXIST = "Owner data already exist on DB";		
	public static final String NO_AFFECT_ROWS_IN_DB = "No affected rows in DB";				
	public static final String MANDATORY_FIELD_EMPTY = "Mandatory field is empty";			
	public static final String RETURNED_SUCCESSFULLY = "The list was returned successfully";
			
	public static final String NULL_SQL_BUILDER_OPTION = "option argument is null";
	public static final String RESULTSET_NOT_APPLICABLE = "Resultset is either not applicable or is empty";		
	public static final String OPERATION_CANT_BE_PROCESSED = "Not possible to process this operation";	
	public static final String SQL_WHERE_CLAUSE_HAS_NO_COLUMN = "SQL Where clause has no column";	
	public static final String AUTO_GENERATED_FIELD_IS_NOT_EMPTY = "Auto generated fields should not be passed";
	public static final String ERROR_CREATING_SKELETON_STATEMENT = "Not possible to create skeleton statment";	

	
	
	//System
	public static final String CONFLICT = "Conflict detected";
	public static final String BAD_TIME_RANGE = "Invalid time range";	
	public static final String DATA_NOT_FOUND = "Data not found";
	public static final String EMPTY_ARGUMENT = " argument is empty";
	public static final String EMPTY_COLUMNS = "No columns for this given builder were passed";
	public static final String INTERNAL_ERROR = "Ops... something went wrong";
	public static final String KEY_FIELD_IS_EMPTY = "Key field should not be null";
	public static final String KEY_FIELD_NOT_NULL = "Key field should not be passed";
	public static final String MULTIPLE_RECORDS = "Multiple records found on DB";
	public static final String NO_CHECK_PERFORMED = "Check operation was not performed";
	public static final String NO_CONFLICT = "No conflict detected";
	public static final String NO_ERROR_FOUND = "No error was found";
	public static final String NO_IMPLEMENTATION = "There is no implementation for this method";	
	public static final String NO_RESPONSE = "Main operation was not executed";
	public static final String NO_TEMPLATE_IMPLEMENTATION = "Template method not overwritten by subclass";
	public static final String NULL_ARGUMENT = " argument is null";
	public static final String NULL_COLUMNS = "Columns for this given builder were passed null";
	public static final String NULL_CONN = "Conn is null";
	public static final String NULL_SCHEMA = "Schema name is null";	
	public static final String REQUEST_FAILED = "It was not possible to complete your request";
	public static final String SUCCESS = "Success";				
	
		
	
	//Master Data
	public static final String CURRENCY_ALREADY_EXIST = "Currency already exist on DB";
	public static final String CURRENCY_NOT_FOUND = "Currency not found on DB";	
	public static final String EMP_POS_ALREADY_EXIST = "Position already exist on DB";
	public static final String EMP_POS_NOT_FOUND = "Position not found on DB";	;	
	public static final String GENDER_ALREADY_EXIST = "Gender already exist on DB";
	public static final String GENDER_NOT_FOUND = "Gender not found on DB";		
	public static final String LANGUAGE_ALREADY_EXIST = "Language already exist on DB";
	public static final String LANGUAGE_NOT_FOUND = "Language not found on DB";
	public static final String MAT_CATEG_ALREADY_EXIST = "Category already exist on DB";
	public static final String MAT_CATEG_NOT_FOUND = "Category not found on DB";
	public static final String MAT_GROUP_ALREADY_EXIST = "Group already exist on DB";
	public static final String MAT_GROUP_NOT_FOUND = "Group not found on DB";	
	public static final String MAT_TYPE_ALREADY_EXIST = "Type already exist on DB";	
	public static final String MAT_TYPE_NOT_FOUND = "Type not found on DB";	
	public static final String UNIT_ALREADY_EXIST = "Unit already exist on DB";
	public static final String UNIT_NOT_FOUND = "Unit not found on DB";
	public static final String WEEKDAY_ALREADY_EXIST = "Weekday already exist on DB";
	public static final String WEEKDAY_NOT_FOUND = "Weekday not found on DB";
	public static final String TIMEZONE_ALREADY_EXIST = "Timezone already exist on DB";
	public static final String TIMEZONE_NOT_FOUND = "Timezone not found on DB";
	
	
	
	//Material
	public static final String MAT_ALREALDY_EXIST = "Material data already exist on DB";	
	public static final String MAT_NOT_FOUND = "Material data not found on DB";
	public static final String MAT_TEXT_ALREALDY_EXIST = "Material text data already exist on DB";
	public static final String MAT_TEXT_NOT_FOUND = "Material text data not found on DB";
		
	
	
	//Employee
	public static final String EMP_ALREALDY_EXIST = "Employee's data already exist on DB";	
	public static final String EMP_CPF_ALREADY_EXIST = "Employee's CPF already exist on DB";	
	public static final String EMP_CPF_NOT_FOUND = "Employee's CPF not found on DB";	
	public static final String EMP_DATA_ALREADY_EXIST = "Employee's data already exist";
	public static final String EMP_DATA_NOT_FOUND = "Employee's data not found";
	public static final String EMP_FLAGGED_AS_DELETED = "Employee's data is flagged as deleted on DB";	
	public static final String EMP_LD_ALREADY_EXIST = "Employee's leave date already exist on DB";
	public static final String EMP_LD_FLAGGED_AS_DELETED = "Employee leave date data is flagged as deleted on DB";	
	public static final String EMP_LD_NOT_FOUND = "Employee's leave date not found on DB";	
	public static final String EMP_MULTIPLE_ENTRIES_FOUND = "Multiple entries found for Employee's data selection";	
	public static final String EMP_NOT_FOUND = "Employee's data not found on DB";	
	public static final String EMP_SINGLE_ENTRY_FOUND = "Single entry found for Employee's data selection";
	public static final String EMP_WTIME_ALREALDY_EXIST = "Employee's working time data already exist on DB";
	public static final String EMP_WTIME_FLAGGED_AS_DELETED = "Employee's working time data is flagged as deleted on DB";			
	public static final String EMP_WTIME_NO_RANGE_FOUND = "Employee's working time range not found on DB";	
	public static final String EMP_WTIME_NOT_FOUND = "Employee's working time data not found on DB";	
	public static final String EMP_WTIME_RANGE_CONFLICT = "Employee's working time range conflict";		
	

			
	//Store		
	public static final String STORE_ALREALDY_EXIST = "Store's data already exist on DB";	
	public static final String STORE_NOT_FOUND = "Store's data not found on DB";
	public static final String STORE_CNPJ_ALREADY_EXIST = "Store's CNPJ already exist on DB";	
	public static final String STORE_CNPJ_NOT_FOUND = "Store's CNPJ not found on DB";
	public static final String STORE_EMP_ALREALDY_EXIST = "Store-Employee's data already exist on DB";
	public static final String STORE_EMP_FLAGGED_AS_DELETED = "Store-Employee's data is flagged as deleted on DB";	
	public static final String STORE_EMP_NOT_FOUND = "Store-Employee's data not found on DB";
	public static final String STORE_MAT_ALREALDY_EXIST = "Store's material data already exist on DB";
	public static final String STORE_MAT_EMP_ALREALDY_EXIST = "Employee's material data already exist on DB";	
	public static final String STORE_MAT_EMP_FLAGGED_AS_DELETED = "Employee's material data is flagged as deleted on DB";
	public static final String STORE_MAT_EMP_NOT_FOUND = "Employee's material data not found on DB";	
	public static final String STORE_MAT_FLAGGED_AS_DELETED = "Store's material data is flagged as deleted on DB";
	public static final String STORE_MAT_NOT_FOUND = "Store's material data not found on DB";
	public static final String STORE_LDATE_ALREADY_EXIST = "Store's leave date already exist on DB";
	public static final String STORE_LDATE_FLAGGED_AS_DELETED = "Store leave date data is flagged as deleted on DB";	
	public static final String STORE_LDATE_NOT_FOUND = "Store's leave date not found on DB";	
	public static final String STORE_WTIME_ALREADY_EXIST = "Store's working time already exist on DB";
	public static final String STORE_WTIME_FLAGGED_AS_DELETED = "Store working time data is flagged as deleted on DB";	
	public static final String STORE_WTIME_NOT_FOUND = "Store's working time not found on DB";
	public static final String STORE_WTIME_VALID_WORKHOUR = "Selected time is valid for Store working time range";	
	public static final String STORE_WTIME_WORKHOUR_OUT_OF_RANGE = "Selected time is out of range of Store working time";
	
			
	
	//Customer
	public static final String CUS_ALREALDY_EXIST = "Customer's data already exist on DB";	
	public static final String CUS_CPF_ALREADY_EXIST = "Customer's CPF already exist on DB";	
	public static final String CUS_CPF_NOT_FOUND = "Customer's CPF not found on DB";	
	public static final String CUS_EMAIL_ALREADY_EXIST = "Customer's e-email already exist on DB";	
	public static final String CUS_EMAIL_CHANGED = "Customer's e-mail changed";	
	public static final String CUS_EMAIL_NOT_FOUND = "Customer's e-email not found on DB";	
	public static final String CUS_EMAIL_NOT_CHANGED = "Customer's e-mail not changed";	
	public static final String CUS_NOT_FOUND = "Customer's data not found on DB";	
}
