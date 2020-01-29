package br.com.mind5.dao.common;

public final class DaoDbTable {	
    //Tables
	public static final String ADDRESS_TABLE = "address";
	public static final String ADDRESS_SNAPSHOT_TABLE = "address_snapshot";
	public static final String ADDRESS_FORM_TABLE = "address_form";
	public static final String AREA_PHONE_TABLE = "area_phone";
	public static final String AREA_PHONE_TEXT_TABLE = "area_phone_text";
	public static final String AUTH_GROUP_TABLE = "auth_group";
	public static final String AUTH_GROUP_ROLE_TABLE = "auth_group_role";
	public static final String BUSINESS_AREA_TABLE = "business_area";
	public static final String BUSINESS_AREA_TEXT_TABLE = "business_area_text";	
	public static final String CART_HDR_TABLE = "shop_cart_header";
	public static final String CART_HDR_SNAPSHOT_TABLE = "shop_cart_header_snapshot";
	public static final String CART_ITM_CATEG_TABLE = "shop_cart_categ";
	public static final String CART_ITM_CATEG_TEXT_TABLE = "shop_cart_categ_text";
	public static final String CART_ITM_TABLE = "shop_cart_item";
	public static final String COMP_TABLE = "company";
	public static final String COMP_SNAPHOT_TABLE = "company_snapshot";
	public static final String COUNTRY_TABLE = "country";
	public static final String COUNTRY_LEGAL_TABLE = "country_legal";
	public static final String COUNTRY_TEXT_TABLE = "country_text";
	public static final String COUNTRY_PHONE_TABLE = "country_phone";
	public static final String CREDIT_CARD_TABLE = "pay_credit_card";
	public static final String CURRENCY_TABLE = "currency_unit";
	public static final String CURRENCY_TEXT_TABLE = "currency_unit_text";	
	public static final String CUS_TABLE = "customer";
	public static final String CUS_SNAPSHOT_TABLE = "customer_snapshot";
	public static final String EMP_TABLE = "employee";	
	public static final String EMP_MAT_TABLE = "employee_material";
	public static final String EMP_SNAPSHOT_TABLE = "employee_snapshot";	
	public static final String EMP_WT_TABLE = "employee_working_time";
	public static final String EMP_LD_TABLE = "employee_leave_time";
	public static final String EMPOS_TABLE = "employee_position";
	public static final String ENTITY_CATEG_TABLE = "entity_categ";
	public static final String ENTITY_CATEG_TEXT_TABLE = "entity_categ_text";
	public static final String FEE_CATEG_TABLE = "fee_categ";
	public static final String FEE_CATEG_TEXT_TABLE = "fee_categ_text";
	public static final String FEE_DEFAULT_TABLE = "fee_default";
	public static final String FEE_OWNER_TABLE = "fee_owner";
	public static final String FILE_IMG_TABLE = "file_image";
	public static final String FILE_PATH_TABLE = "file_path";
	public static final String GENDER_TABLE = "gender";
	public static final String GENDER_TEXT_TABLE = "gender_text";
	public static final String LANGUAGE_TABLE = "language";
	public static final String MAT_CATEG_TABLE = "material_category";			
	public static final String MAT_CATEG_TEXT_TABLE = "material_category_text";		
	public static final String MAT_GROUP_TABLE = "material_group";
	public static final String MAT_GROUP_TEXT_TABLE = "material_group_text";
	public static final String MAT_MOV_TYPE_TABLE = "material_movement_type";
	public static final String MAT_MOV_TYPE_TEXT_TABLE = "material_movement_type_text";
	public static final String MAT_MOVEMENT_TABLE = "material_movement";
	public static final String MAT_STOCK_TABLE = "material_stock";
	public static final String MAT_STORE_TABLE = "material_store";
	public static final String MAT_STORE_SNAPSHOT_TABLE = "material_store_snapshot";
	public static final String MAT_TABLE = "material";
	public static final String MAT_SNAPSHOT_TABLE = "material_snapshot";
	public static final String MAT_TEXT_TABLE = "material_text";
	public static final String MAT_TEXT_SNAPSHOT_TABLE = "material_text_snapshot";
	public static final String MAT_TYPE_TABLE = "material_type";
	public static final String MAT_TYPE_TEXT_TABLE = "material_type_text";
	public static final String MAT_UNIT_TABLE = "measure_unit";
	public static final String MAT_UNIT_TEXT_TABLE = "measure_unit_text";
	public static final String MONTH_TEXT_TABLE = "month_text";
	public static final String MOIP_PERMISSION_RESPONSE_TABLE = "moip_permission_reponse";
	public static final String ORDER_HDR_TABLE = "order_header";
	public static final String ORDER_HDR_SNAPSHOT_TABLE = "order_header_snapshot";
	public static final String ORDER_ITM_TABLE = "order_item";
	public static final String ORDER_ITM_SNAPSHOT_TABLE = "order_item_snapshot";
	public static final String ORDER_STATUS_TABLE = "order_status";
	public static final String ORDER_STATUS_TEXT_TABLE = "order_status_text";
	public static final String OWNER_TABLE = "owner";
	public static final String OWNER_SNAPSHOT_TABLE = "owner_snapshot";
	public static final String PAY_CUS_TABLE = "pay_customer";
	public static final String PAY_ORDER_HDR_TABLE = "pay_order_header";
	public static final String PAY_ORDER_ITM_TABLE = "pay_order_item";
	public static final String PAY_PARTNER_TABLE = "pay_partner";
	public static final String PAY_PARTNER_COUNTRY_TABLE = "pay_partner_country";	
	public static final String PAY_PARTNER_OWNER_TABLE = "pay_partner_owner";
	public static final String PAY_PARTNER_SETUP_TABLE = "pay_partner_setup";
	public static final String PAY_PARTNER_STORE_TABLE = "pay_partner_store";
	public static final String PAY_PARTNER_STORE_SNAPSHOT_TABLE = "pay_partner_store_snapshot";
	public static final String PAYMENT_STATUS_TABLE = "payment_status";
	public static final String PAYMENT_STATUS_TEXT_TABLE = "payment_status_text";
	public static final String PERSON_TABLE = "person";
	public static final String PERSON_SNAPSHOT_TABLE = "person_snapshot";
	public static final String PHONE_TABLE = "phone";
	public static final String PHONE_FORM_TABLE = "phone_form";
	public static final String PHONE_SNAPSHOT_TABLE = "phone_snapshot";
	public static final String POSITION_TABLE = "position";
	public static final String POSITION_TEXT_TABLE = "position_text";
	public static final String TIMEZONE_TABLE = "timezone";
	public static final String TIMEZONE_TEXT_TABLE = "timezone_text";
	public static final String SCHEDULE_TABLE = "schedule";	
	public static final String SCHEDULE_MONTH_TABLE = "vw_schedule_month";
	public static final String SCHEDULE_MOVIMENT_TABLE = "schedule_moviment";
	public static final String SCHEDULE_SNAPSHOT_TABLE = "schedule_snapshot";
	public static final String SCHEDULE_STATUS_TABLE = "schedule_status";
	public static final String SCHEDULE_STATUS_TEXT_TABLE = "schedule_status_text";
	public static final String SCHEDULE_WEEK_TABLE = "vw_schedule_week";
	public static final String SCHEDULE_YEAR_TABLE = "vw_schedule_year";
	public static final String STATE_TABLE = "state";
	public static final String STATE_TEXT_TABLE = "state_text";
	public static final String STORE_TABLE = "store";
	public static final String STORE_SNAPSHOT_TABLE = "store_snapshot";
	public static final String STORE_LD_TABLE = "store_leave_time";
	public static final String STORE_WT_TABLE = "store_working_time";
	public static final String SYS_EMAIL_TABLE = "sys_email";
	public static final String SYS_EMAIL_BODY_TABLE = "sys_email_body";
	public static final String SYS_MESSAGE_TABLE = "sys_message";
	public static final String SYS_PAY_PARTNER_TABLE = "sys_pay_partner";
	public static final String SYS_ENVIRONMENT_TABLE = "system_environment";
	public static final String UNIT_TABLE = "measure_unit";
	public static final String UNIT_TEXT_TABLE = "measure_unit_text";	
	public static final String USER_TABLE = "user";
	public static final String USER_CATEG_TABLE = "user_categ";
	public static final String USER_CATEG_TEXT_TABLE = "user_categ_text";
	public static final String USER_PASSWORD_TABLE = "user_password";
	public static final String USER_SNAPSHOT_TABLE = "user_snapshot";
	public static final String WEEKDAY_TABLE = "weekday";
	public static final String WEEKDAY_TEXT_TABLE = "weekday_text";
	
	
	
	
    //Views
	public static final String ADDRESS_SEARCH_VIEW = "view_address_search";
	public static final String CART_ITM_SEARCH_VIEW = "view_shop_cart_item_search";
	public static final String CART_RESERVE_VIEW = "view_cart_reserve";	
	public static final String COMPANY_LIST_VIEW = "view_company_list";	
	public static final String COMP_CONFLICT_VIEW = "view_company_conflict";	
	public static final String COMP_SEARCH_VIEW = "view_company_search";	
	public static final String CUS_LIST_VIEW = "view_customer_list";	
	public static final String CUS_SEARCH_VIEW = "view_customer_search";
	public static final String EMP_LD_RANGE_VIEW = "employee_leave_time_range_view";
	public static final String EMP_LD_SEARCH_VIEW = "employee_leave_time_search_view";
	public static final String EMP_LIST_VIEW = "view_employee_list";	
	public static final String EMP_MAT_SEARCH_VIEW = "view_employee_material_search";
	public static final String EMP_SEARCH_VIEW = "view_employee_search";	
	public static final String EMP_WT_CONFLICT_VIEW = "view_employee_working_time";
	public static final String EMP_WT_OUTLIER_VIEW = "view_employee_working_time_outlier";
	public static final String EMP_WTIME_RANGE_VIEW = "view_employee_wtime_range";
	public static final String EMP_WT_SEARCH_VIEW = "view_employee_working_time_search";	
	public static final String EMPOS_LIST_VIEW = "view_employee_position_list";	
	public static final String EMPOS_SEARCH_VIEW = "view_employee_position_search";	
	public static final String FILE_IMG_LIST_VIEW = "view_file_image_list";	
	public static final String FILE_IMG_SEARCH_VIEW = "view_file_image_search";
	public static final String MAT_LIST_VIEW = "view_material_list";
	public static final String MAT_MOVEMENT_SEARCH_VIEW = "view_material_movement_search";
	public static final String MAT_STOCK_SEARCH_VIEW = "view_material_stock_search";
	public static final String MAT_STORE_SEARCH_VIEW = "view_material_store_search";
	public static final String MAT_TEXT_SEARCH_VIEW = "view_material_text_search";
	public static final String MAT_TEXT_DEFAULT_VIEW = "view_material_text_default";
	public static final String MAT_SEARCH_VIEW = "view_material_search";
	public static final String OWNER_LIST_VIEW = "view_owner_list";
	public static final String ORDER_LIST_VIEW = "view_order_list";
	public static final String ORDER_ITM_SEARCH_VIEW = "view_order_item_search";
	public static final String ORDER_RESERVE_VIEW = "view_order_reserve";	
	public static final String ORDER_SEARCH_VIEW = "view_order_search";	
	public static final String PAY_PARTNER_STORE_VIEW = "view_pay_partner_store";
	public static final String PAY_PARTNER_STORE_SEARCH_VIEW = "view_pay_partner_store_search";
	public static final String PAYMENT_VIEW = "view_payment";
	public static final String PERSON_LIST_VIEW = "view_person_list";	
	public static final String PERSON_SEARCH_VIEW = "view_person_search";
	public static final String PHONE_SEARCH_VIEW = "view_phone_search";
	public static final String PLANING_DATA_VIEW = "planing_data_list";
	public static final String REFUND_VIEW = "view_refund";	
	public static final String SCHEDULE_LIST_VIEW = "view_list_search";
	public static final String SCHEDULE_RANGE_VIEW = "view_schedule_range";
	public static final String SCHEDULE_SEARCH_VIEW = "view_schedule_search";
	public static final String STORE_AUTH_VIEW = "store_auth_view";
	public static final String STORE_LD_RANGE_VIEW = "store_leave_time_range_view";
	public static final String STORE_LD_SEARCH_VIEW = "view_store_leave_time_search";	
	public static final String STORE_LIST_VIEW = "view_store_list";	
	public static final String STORE_SEARCH_VIEW = "view_store_search";	
	public static final String STORE_WTIME_RANGE_VIEW = "view_store_wtime_range";
	public static final String STORE_WTIME_SEARCH_VIEW = "view_store_wtime_search";
	public static final String USER_LIST_VIEW = "view_user_list";
	public static final String USER_SEARCH_VIEW = "view_user_search";
	public static final String USERNAME_VIEW = "view_username";	
}
