package br.com.gda.common;

public final class SystemMessage {
	//TODO: Organizar essas Strings
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
	public static final String ACTION_NOT_EXECUTED = "Action has not been executed";
	public static final String ACTION_NOT_INIT = " is NULL or EMPTY. Action was not initialized as expected";
	public static final String AGED_DATE = "Date is in the past";
	public static final String ARGUMENT_DONT_MATCH = " arguments don't match";
	public static final String BAD_DATE = "Invalid date";	
	public static final String BAD_TIME_RANGE = "Invalid time range";	
	public static final String CLASS_MISMATCH = "Class type mismatch";	
	public static final String COMPARE_NOT_POSSIBLE = "Not possible to compare objects. Equals() was broken";	
	public static final String CONFLICT = "Conflict detected";
	public static final String DATA_NOT_FOUND = "Data not found";
	public static final String EMPTY_ARGUMENT = " argument is empty";
	public static final String EMPTY_COLUMNS = "No columns for this given builder were passed";
	public static final String INTERNAL_ERROR = "Ops... something went wrong";
	public static final String KEY_FIELD_IS_EMPTY = "Key field should not be null";
	public static final String KEY_FIELD_NOT_NULL = "Key field should not be passed";
	public static final String LIMIT_EXCEEDED = "Limit exceeded";	
	public static final String MERGE_NOT_POSSIBLE = "Merge operation not possible";	
	public static final String MERGE_RETURNED_NULL = "Merge operation returned null";	
	public static final String MERGE_NOT_ALLOWED = "Merge operation not allowed";
	public static final String MIN_SIZE_REQUIRED = "Size should be greater or equal to: ";	
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
	public static final String OBJ_NOT_INITIALIED = "Object was not initialized or operartion not applicable for current state";
	public static final String POSITIVE_NUM_EXPECTED = " should be positive and greater than zero";	
	public static final String REQUEST_FAILED = "It was not possible to complete your request";
	public static final String REQUEST_NOT_EXECUTED = "Request has not been executed";
	public static final String SUCCESS = "Success";			
	public static final String WRONG_DATA_TYPE = "Wrong data type";	
	
	
		
	//Master Data
	public static final String AREA_PHONE_ALREADY_EXIST = "Phone Area already exist on DB";
	public static final String AREA_PHONE_NOT_FOUND = "Phone Area not found on DB";	
	public static final String COUNTRY_ALREADY_EXIST = "Country already exist on DB";
	public static final String COUNTRY_NOT_FOUND = "Country not found on DB";	
	public static final String COUNTRY_PHONE_ALREADY_EXIST = "Phone Country code already exist on DB";
	public static final String COUNTRY_PHONE_NOT_FOUND = "Phone Country code not found on DB";	
	public static final String CURRENCY_ALREADY_EXIST = "Currency already exist on DB";
	public static final String CURRENCY_NOT_FOUND = "Currency not found on DB";	
	public static final String EMP_POS_ALREADY_EXIST = "Position already exist on DB";
	public static final String EMP_POS_NOT_FOUND = "Position not found on DB";	
	public static final String ENTITY_CATEG_ALREADY_EXIST = "Entity Category already exist on DB";
	public static final String ENTITY_CATEG_NOT_FOUND = "Entity Category not found on DB";		
	public static final String FEE_CATEG_ALREADY_EXIST = "Fee Category already exist on DB";
	public static final String FEE_CATEG_NOT_FOUND = "Fee Category not found on DB";
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
	public static final String STATE_ALREADY_EXIST = "State already exist on DB";
	public static final String STATE_NOT_FOUND = "State not found on DB";
	public static final String TIMEZONE_ALREADY_EXIST = "Timezone already exist on DB";
	public static final String TIMEZONE_NOT_FOUND = "Timezone not found on DB";

		
	
	//Material
	public static final String MAT_ALREALDY_EXIST = "Material data already exist on DB";	
	public static final String MAT_NOT_FOUND = "Material data not found on DB";
	public static final String MAT_NOT_SERVICE	= "Material's category is not a service";
	public static final String MAT_SERVICE = "Material's category is a service";
	public static final String MAT_TEXT_ALREADY_EXIST = "Material text data already exist on DB";
	public static final String MAT_TEXT_NOT_FOUND = "Material text data not found on DB";
			
	
	
	//Employee
	public static final String EMP_ALREALDY_EXIST = "Employee's data already exist on DB";	
	public static final String EMP_CPF_ALREADY_EXIST = "Employee's CPF already exist on DB";	
	public static final String EMP_CPF_NOT_FOUND = "Employee's CPF not found on DB";	
	public static final String EMP_DATA_ALREADY_EXIST = "Employee's data already exist";
	public static final String EMP_DATA_NOT_FOUND = "Employee's data not found";
	public static final String EMP_FLAGGED_AS_DELETED = "Employee's data is flagged as deleted on DB";	
	public static final String EMP_LDATE_ALREADY_EXIST = "Employee's leave date already exist on DB";
	public static final String EMP_LDATE_FLAGGED_AS_DELETED = "Employee leave date data is flagged as deleted on DB";
	public static final String EMP_LDATE_LEAVE_FOUND = "There is a employee's leave date for selected time";
	public static final String EMP_LDATE_NO_LEAVE_FOUND = "Selected time is free of employee's leave dates";	
	public static final String EMP_LDATE_NOT_FOUND = "Employee's leave date not found on DB";
	public static final String EMP_MULTIPLE_ENTRIES_FOUND = "Multiple entries found for Employee's data selection";	
	public static final String EMP_NOT_FOUND = "Employee's data not found on DB";	
	public static final String EMP_SINGLE_ENTRY_FOUND = "Single entry found for Employee's data selection";
	public static final String EMP_WTIME_ALREALDY_EXIST = "Employee's working time data already exist on DB";
	public static final String EMP_WTIME_FLAGGED_AS_DELETED = "Employee's working time data is flagged as deleted on DB";			
	public static final String EMP_WTIME_NO_RANGE_FOUND = "Employee's working time range not found on DB";	
	public static final String EMP_WTIME_NOT_FOUND = "Employee's working time data not found on DB";	
	public static final String EMP_WTIME_RANGE_CONFLICT = "Employee's working time range conflict";	
	public static final String EMP_WTIME_VALID_WORKHOUR = "Selected time is valid for Employee working time range";	
	public static final String EMP_WTIME_WORKHOUR_OUT_OF_RANGE = "Selected time is out of range of Employee working time";
	
	
			
	//Store		
	public static final String STORE_ALREALDY_EXIST = "Store's data already exist on DB";	
	public static final String STORE_NOT_FOUND = "Store's data not found on DB";
	public static final String STORE_CNPJ_ALREADY_EXIST = "Store's CNPJ already exist on DB";	
	public static final String STORE_CNPJ_NOT_FOUND = "Store's CNPJ not found on DB";
	public static final String STORE_EMP_ALREADY_EXIST = "Store-Employee's data already exist on DB";
	public static final String STORE_EMP_FLAGGED_AS_DELETED = "Store-Employee's data is flagged as deleted on DB";	
	public static final String STORE_EMP_NOT_FOUND = "Store-Employee's data not found on DB";
	public static final String STORE_FEE_ALREADY_EXIST = "Store's fee data already exist on DB";
	public static final String STORE_FEE_NOT_FOUND = "Store's fee data not found on DB";
	public static final String STORE_MAT_ALREADY_EXIST = "Store's material data already exist on DB";
	public static final String STORE_MAT_EMP_ALREADY_EXIST = "Employee's material data already exist on DB";	
	public static final String STORE_MAT_EMP_FLAGGED_AS_DELETED = "Employee's material data is flagged as deleted on DB";
	public static final String STORE_MAT_EMP_NOT_FOUND = "Employee's material data not found on DB";	
	public static final String STORE_MAT_FLAGGED_AS_DELETED = "Store's material data is flagged as deleted on DB";
	public static final String STORE_MAT_NOT_FOUND = "Store's material data not found on DB";
	public static final String STORE_LDATE_ALREADY_EXIST = "Store's leave date already exist on DB";
	public static final String STORE_LDATE_FLAGGED_AS_DELETED = "Store leave date data is flagged as deleted on DB";	
	public static final String STORE_LDATE_NOT_FOUND = "Store's leave date not found on DB";	
	public static final String STORE_WTIME_ALREADY_EXIST = "Store's working time already exist on DB";
	public static final String STORE_WTIME_FLAGGED_AS_DELETED = "Store working time data is flagged as deleted on DB";	
	public static final String STORE_WTIME_LEAVE_FOUND = "There is a store's leave date for selected time";
	public static final String STORE_WTIME_NO_LEAVE_FOUND = "Selected time is free of store's leave dates";
	public static final String STORE_WTIME_NOT_FOUND = "Store's working time not found on DB";
	public static final String STORE_WTIME_VALID_WORKHOUR = "Selected time is valid for Store working time range";	
	public static final String STORE_WTIME_WORKHOUR_OUT_OF_RANGE = "Selected time is out of range of Store working time";
		
	
	
	//Customer
	public static final String CUS_ALREADY_EXIST = "Customer's data already exist on DB";	
	public static final String CUS_CPF_ALREADY_EXIST = "Customer's CPF already exist on DB";	
	public static final String CUS_CPF_NOT_FOUND = "Customer's CPF not found on DB";	
	public static final String CUS_EMAIL_ALREADY_EXIST = "Customer's e-email already exist on DB";	
	public static final String CUS_EMAIL_CHANGED = "Customer's e-mail changed";	
	public static final String CUS_EMAIL_NOT_FOUND = "Customer's e-email not found on DB";	
	public static final String CUS_EMAIL_NOT_CHANGED = "Customer's e-mail not changed";	
	public static final String CUS_NOT_FOUND = "Customer's data not found on DB";	
	
	
	
	//Cart
	public static final String CART_ALREADY_EXIST = "Cart's data already exist on DB";	
	public static final String CART_HAVE_ITEM = "Cart still has items";	
	public static final String CART_IS_EMPTY = "Cart is empty";
	public static final String CART_MAT_ALREADY_EXIST = "Material already added to Cart";	
	public static final String CART_MAT_NOT_FOUND = "Material not found on Cart";
	public static final String CART_NOT_FOUND = "Cart's data not found on DB";	
	public static final String CART_ITEM_ALREADY_EXIST = "Cart item already exist on DB";	
	public static final String CART_ITEM_NOT_FOUND = "Cart item not found on DB";
	
		
	
	//Order
	public static final String ORDER_STATUS_ALREADY_EXIST = "Order Status already exist on DB";	
	public static final String ORDER_STATUS_NOT_FOUND = "Order Status not found on DB";
	
		
	
	//Total Amount
	public static final String AMOUNT_DONT_HAVE_TWO_DECIMAL_PLACES = "Amount field does not have two decimal places";
		
	
	
	//Phone
	public static final String PHONE_NUMBER_IS_NULL = "Phone number is blank";
	public static final String PHONE_NUMBER_IS_FILLED = "Phone number is not blank";
	public static final String PHONE_COUNTRY_IS_BR = "Phone country code refers to Brazil";
	public static final String PHONE_COUNTRY_IS_NOT_BR = "Phone country code doens't refer to Brazil";
	public static final String PHONE_NUMBER_INVALID = "Phone number is invalid";
	public static final String PHONE_NUMBER_IS_VALID = "Phone number is valid";
	public static final String PHONE_NUMBER_INVALID_LENGTH = "Invalid phone length";
	public static final String PHONE_NUMBER_INVALID_LENGTH_BR = "Invalid phone length. Area code is expected";
	public static final String PHONE_NUMBER_INVALID_NUMBER = "Only numbers are allowed for phone";
	public static final String PHONE_NUMBER_INVALID_AREA_CODE = "Invalid area code for phone number";
	public static final String PHONE_NUMBER_INVALID_SEQUENCE = "Invalid sequence for phone number";	
	public static final String PHONE_WITHOUT_REFERENCE = "No reference added to Phone";
	public static final String PHONE_MULTIPLE_REFERENCE = "Phone has multiple references";
	public static final String PHONE_LIMIT_EXCEEDED = "Phone limit exceeded. Delete old phones before adding new ones";
	public static final String PHONE_NOT_FOUND = "Phone not found on DB";
	public static final String PHONE_ALREADY_EXIST = "Phone already exist";
	public static final String PHONE_IS_NEW = "New Phone record";
	public static final String PHONE_IS_OLD = "Old Phone record";
	public static final String PHONE_FLAG_DELETE_TRUE = "Phone flagged to deletion";
	public static final String PHONE_FLAG_DELETE_FALSE = "No Phone flagged to deletion";
	public static final String PHONE_IS_NULL = "Phone is blank";
	public static final String PHONE_IS_FILLED = "Phone is not blank";
	public static final String PHONE_COD_IS_FILLED = "Code Phone should be blank";
		
	
	
	//Address
	public static final String ADDRESS_IS_NULL = "Address is blank";
	public static final String ADDRESS_IS_FILLED = "Address is not blank";
	public static final String ADDRESS_NOT_FOUND = "Address not found on DB";
	public static final String ADDRESS_ALREADY_EXIST = "Address already exist";
	public static final String ADDRESS_IS_NEW = "New Address record";
	public static final String ADDRESS_IS_OLD = "Old Address record";
	public static final String ADDRESS_WITHOUT_REFERENCE = "No reference added to Address";
	public static final String ADDRESS_MULTIPLE_REFERENCE = "Address has multiple references";
	public static final String ADDRESS_FLAG_DELETE_TRUE = "Address flagged to deletion";
	public static final String ADDRESS_FLAG_DELETE_FALSE = "No Address flagged to deletion";
	public static final String ADDRESS_LIMIT_EXCEEDED = "Address limit exceeded. Delete old addresses before adding new ones";
	public static final String ADDRESS_COD_IS_FILLED = "Code Address should be blank";
			
	
	
	//Form
	public static final String FORM_ADDRESS_ALREADY_EXIST = "Address form already exist on DB";
	public static final String FORM_ADDRESS_NOT_FOUND = "Address form not found on DB";
	public static final String FORM_ADDRESS_INVALID = "Invalid address form";
	public static final String FORM_PHONE_INVALID = "Invalid address form";
	
	
	
	//Person
	public static final String PERSON_CPF_BLANK = "CPF is empty";
	public static final String PERSON_CPF_INVALID_NUMBER = "Only numbers are allowed for CPF";
	public static final String PERSON_CPF_INVALID_LENGTH = "Invalid CPF length";
	public static final String PERSON_CPF_INVALID_SEQUENCE = "Invalid sequence for CPF";	
	public static final String PERSON_CPF_INVALID = "CPF is invalid";
	public static final String PERSON_CPF_ALREADY_EXIST = "CPF already exist on DB";	
	public static final String PERSON_CPF_NOT_FOUND = "CPF not found on DB";	
	public static final String PERSON_EMAIL_BLANK = "Email is empty";
	public static final String PERSON_EMAIL_ALREADY_EXIST = "e-email already exist on DB";	
	public static final String PERSON_EMAIL_NOT_FOUND = "e-email not found on DB";	
	public static final String PERSON_ALREADY_EXIST = "Person already exist on DB";	
	public static final String PERSON_NOT_FOUND = "Person not found on DB";	
	public static final String PERSON_EMAIL_NOT_CHANGED = "e-mail not changed";	
	public static final String PERSON_EMAIL_CHANGED = "e-mail has been changed";	
	public static final String PERSON_CPF_NOT_CHANGED = "CPF not changed";	
	public static final String PERSON_CPF_CHANGED = "CPF has been changed";	
	public static final String PERSON_CPF_CANT_BE_CHANGED = "CPF can't be changed";	
	public static final String PERSON_EMAIL_CANT_BE_CHANGED = "e-mail can't be changed";	
	public static final String PERSON_CPF_NO_ERASURE = "No CPF erasure";	
	public static final String PERSON_CPF_ERASURE = "CPF erasure is not allowed";	
	public static final String PERSON_EMAIL_NO_ERASURE = "No e-mail erasure";	
	public static final String PERSON_EMAIL_ERASURE = "e-mail erasure is not allowed";	
}
