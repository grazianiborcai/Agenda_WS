package br.com.gda.dao;

public final class DaoDbTable {	
    //Tables
	public static final String ADDRESS_TABLE = "address";
	public static final String ADDRESS_SNAPSHOT_TABLE = "address_snapshot";
	public static final String ADDRESS_FORM_TABLE = "address_form";
	public static final String AREA_PHONE_TABLE = "area_phone";
	public static final String AREA_PHONE_TEXT_TABLE = "area_phone_text";
	public static final String BUSINESS_AREA_TABLE = "business_area";
	public static final String BUSINESS_AREA_TEXT_TABLE = "business_area_text";	
	public static final String CART_HDR_TABLE = "shop_cart_header";
	public static final String CART_HDR_SNAPSHOT_TABLE = "shop_cart_header_snapshot";
	public static final String CART_ITM_CATEG_TABLE = "shop_cart_categ";
	public static final String CART_ITM_CATEG_TEXT_TABLE = "shop_cart_categ_text";
	public static final String CART_ITM_TABLE = "shop_cart_item";
	public static final String CART_ITM_SNAPSHOT_TABLE = "shop_cart_item_snapshot";
	public static final String COUNTRY_TABLE = "country";
	public static final String COUNTRY_TEXT_TABLE = "country_text";
	public static final String COUNTRY_PHONE_TABLE = "country_phone";
	public static final String CURRENCY_TABLE = "currency_unit";
	public static final String CURRENCY_TEXT_TABLE = "currency_unit_text";	
	public static final String CUS_TABLE = "customer";
	public static final String EMP_TABLE = "employee";	
	public static final String EMP_WT_TABLE = "employee_working_time";
	public static final String EMP_LD_TABLE = "employee_leave_time";
	public static final String ENTITY_CATEG_TABLE = "entity_categ";
	public static final String ENTITY_CATEG_TEXT_TABLE = "entity_categ_text";
	public static final String FEE_CATEG_TABLE = "fee_categ";
	public static final String FEE_CATEG_TEXT_TABLE = "fee_categ_text";
	public static final String FEE_DEFAULT_TABLE = "fee_default";
	public static final String FEE_STORE_TABLE = "fee_store";
	public static final String GENDER_TABLE = "gender";
	public static final String GENDER_TEXT_TABLE = "gender_text";
	public static final String LANGUAGE_TABLE = "language";
	public static final String MAT_CATEG_TABLE = "material_category";			
	public static final String MAT_CATEG_TEXT_TABLE = "material_category_text";	
	public static final String MAT_EMP_TABLE = "employee_material";
	public static final String MAT_GROUP_TABLE = "material_group";
	public static final String MAT_GROUP_TEXT_TABLE = "material_group_text";
	public static final String MAT_STORE_TABLE = "material_store";
	public static final String MAT_TABLE = "material";
	public static final String MAT_SNAPSHOT_TABLE = "material_snapshot";
	public static final String MAT_TEXT_TABLE = "material_text";
	public static final String MAT_TEXT_SNAPSHOT_TABLE = "material_text_snapshot";
	public static final String MAT_TYPE_TABLE = "material_type";
	public static final String MAT_TYPE_TEXT_TABLE = "material_type_text";
	public static final String MAT_UNIT_TABLE = "measure_unit";
	public static final String MAT_UNIT_TEXT_TABLE = "measure_unit_text";
	public static final String ORDER_TABLE = "order";
	public static final String ORDER_STATUS_TABLE = "order_status";
	public static final String ORDER_STATUS_TEXT_TABLE = "order_status_text";
	public static final String OWNER_TABLE = "owner";
	public static final String PERSON_TABLE = "person";
	public static final String PERSON_SNAPSHOT_TABLE = "person_snapshot";
	public static final String PHONE_TABLE = "phone";
	public static final String PHONE_FORM_TABLE = "phone_form";
	public static final String PHONE_SNAPSHOT_TABLE = "phone_snapshot";
	public static final String POSITION_TABLE = "position";
	public static final String POSITION_TEXT_TABLE = "position_text";
	public static final String TIMEZONE_TABLE = "timezone";
	public static final String TIMEZONE_TEXT_TABLE = "timezone_text";
	public static final String SNAPSHOT_HDR_TABLE = "snapshot_header";
	public static final String STATE_TABLE = "state";
	public static final String STATE_TEXT_TABLE = "state_text";
	public static final String STORE_EMP_TABLE = "store_emp";
	public static final String STORE_TABLE = "store";
	public static final String STORE_LD_TABLE = "store_leave_time";
	public static final String STORE_WT_TABLE = "store_working_time";
	public static final String UNIT_TABLE = "measure_unit";
	public static final String UNIT_TEXT_TABLE = "measure_unit_text";	
	public static final String USER_TABLE = "user";
	public static final String USER_SNAPSHOT_TABLE = "user_snapshot";
	public static final String WEEKDAY_TABLE = "weekday";
	public static final String WEEKDAY_TEXT_TABLE = "weekday_text";
	
	
	
	
    //Views
	public static final String EMP_WT_CONFLICT_VIEW = "view_employee_working_time";
	public static final String RESERVE_VIEW = "view_reserve";		
	public static final String PERSON_CUS_VIEW = "view_person_customer";
	public static final String PERSON_USER_VIEW = "view_person_user";	
	public static final String STORE_WT_CONFLICT_VIEW = "view_store_working_time";
}
