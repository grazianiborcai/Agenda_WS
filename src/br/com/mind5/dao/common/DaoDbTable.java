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
	public static final String BANK_ACCOUNT_TABLE = "bank_account";
	public static final String BANK_ACCOUNT_SNAPSHOT_TABLE = "bank_account_snapshot";
	public static final String BANK_TABLE = "bank";
	public static final String BANK_TEXT_TABLE = "bank_text";
	public static final String BANK_ACCOUNT_TYPE_TABLE = "bank_account_type";
	public static final String BANK_ACCOUNT_TYPE_TEXT_TABLE = "bank_account_type_text";
	public static final String BANK_HOLDER_TYPE_TABLE = "bank_holder_type";
	public static final String BANK_HOLDER_TYPE_TEXT_TABLE = "bank_holder_type_text";
	public static final String BUSINESS_AREA_TABLE = "business_area";
	public static final String BUSINESS_AREA_TEXT_TABLE = "business_area_text";
	public static final String CALENDAR_DATE_TABLE = "calendar_date";
	public static final String CALENDAR_MONTH_TABLE = "calendar_month";
	public static final String CALENDAR_WEEK_YEAR_TABLE = "calendar_week_year";
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
	public static final String DAYPART_TABLE = "dayparting";
	public static final String DAYPART_TEXT_TABLE = "dayparting_text";
	public static final String DISCOUNT_COUPON_ITEM_TABLE = "discount_coupon_item";
	public static final String DISCOUNT_STORE_TABLE = "discount_store";
	public static final String DISCOUNT_STORE_SNAPSHOT_TABLE = "discount_store_snapshot";
	public static final String DISCOUNT_STRATEGY_TABLE = "discount_strategy";
	public static final String DISCOUNT_STRATEGY_TEXT_TABLE = "discount_strategy";
	public static final String EMP_TABLE = "employee";
	public static final String EMP_MAT_TABLE = "employee_material";
	public static final String EMP_SNAPSHOT_TABLE = "employee_snapshot";
	public static final String EMP_LT_TABLE = "employee_lunch_time";
	public static final String EMP_WT_TABLE = "employee_working_time";
	public static final String EMP_LT_SNAPSHOT_TABLE = "employee_lunch_time_snapshot";
	public static final String EMP_WT_SNAPSHOT_TABLE = "employee_working_time_snapshot";
	public static final String EMP_LD_TABLE = "employee_leave_time";
	public static final String EMPOS_TABLE = "employee_position";
	public static final String ENTITY_CATEG_TABLE = "entity_categ";
	public static final String ENTITY_CATEG_TEXT_TABLE = "entity_categ_text";
	public static final String FEE_CATEG_TABLE = "fee_categ";
	public static final String FEE_CATEG_TEXT_TABLE = "fee_categ_text";
	public static final String FEE_DEFAULT_TABLE = "fee_default";
	public static final String FEE_OWNER_TABLE = "fee_owner";
	public static final String FILE_DOC_TYPE_TABLE = "file_doc_type";
	public static final String FILE_DOC_TYPE_TEXT_TABLE = "file_doc_type_text";
	public static final String FILE_IMG_TABLE = "file_image";
	public static final String FILE_IMG_SNAPSHOT_TABLE = "file_image_snapshot";
	public static final String FILE_PATH_TABLE = "file_path";
	public static final String GENDER_TABLE = "gender";
	public static final String GENDER_TEXT_TABLE = "gender_text";
	public static final String LANGUAGE_TABLE = "language";
	public static final String LEGAL_PERSON_TABLE = "legal_person";
	public static final String MAT_CATEG_TABLE = "material_category";
	public static final String MAT_CATEG_TEXT_TABLE = "material_category_text";
	public static final String MAT_GROUP_TABLE = "material_group";
	public static final String MAT_GROUP_OWNER_TABLE = "material_group_owner";
	public static final String MAT_GROUP_TEXT_TABLE = "material_group_text";
	public static final String MAT_MOV_TYPE_TABLE = "material_movement_type";
	public static final String MAT_MOV_TYPE_TEXT_TABLE = "material_movement_type_text";
	public static final String MAT_MOVEMENT_TABLE = "material_movement";
	public static final String MAT_STOCK_TABLE = "material_stock";
	public static final String MAT_STORE_TABLE = "material_store";
	public static final String MAT_STORE_SNAPSHOT_TABLE = "material_store_snapshot";
	public static final String MAT_SUBGROUP_TABLE = "material_subgroup";
	public static final String MAT_SUBGROUP_TEXT_TABLE = "material_subgroup_text";
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
	public static final String MOON_CALENDAR_TABLE = "moon_calendar";
	public static final String MOON_PHASE_TABLE = "moon_phase";
	public static final String MOON_PHASE_TEXT_TABLE = "moon_phase_text";
	public static final String NOTES_TABLE = "notes";
	public static final String ORDER_HDR_TABLE = "order_header";
	public static final String ORDER_HDR_SNAPSHOT_TABLE = "order_header_snapshot";
	public static final String ORDER_ITM_TABLE = "order_item";
	public static final String ORDER_ITM_SNAPSHOT_TABLE = "order_item_snapshot";
	public static final String ORDER_STATUS_TABLE = "order_status";
	public static final String ORDER_STATUS_TEXT_TABLE = "order_status_text";
	public static final String OTP_PROSPECT_STORE_TABLE = "otp_prospect_store";
	public static final String OTP_USER_PASSWORD_TABLE = "otp_user_password";
	public static final String OWNER_TABLE = "owner";
	public static final String OWNER_CONFIG_TABLE = "owner_config";
	public static final String OWNER_SNAPSHOT_TABLE = "owner_snapshot";
	public static final String PAY_CUS_TABLE = "pay_customer";
	public static final String PAY_ORDER_HDR_TABLE = "pay_order_header";
	public static final String PAY_ORDER_ITM_TABLE = "pay_order_item";
	public static final String PAY_PARTNER_TABLE = "pay_partner";
	public static final String PAY_PARTNER_CONFIG_TABLE = "pay_partner_config";
	public static final String PAY_PARTNER_COUNTRY_TABLE = "pay_partner_country";
	public static final String PAY_PARTNER_MARKETPLACE_TABLE = "pay_partner_marketplace";
	public static final String PAY_PARTNER_OWNER_TABLE = "pay_partner_owner";
	public static final String PAY_PARTNER_SETUP_TABLE = "pay_partner_setup";
	public static final String PAY_PARTNER_STORE_TABLE = "pay_partner_store";
	public static final String PAY_PARTNER_STORE_SNAPSHOT_TABLE = "pay_partner_store_snapshot";
	public static final String PAYMENT_STATUS_TABLE = "payment_status";
	public static final String PAYMENT_STATUS_TEXT_TABLE = "payment_status_text";
	public static final String PERSON_TABLE = "person";
	public static final String PERSON_BIO_TABLE = "person_bio";
	public static final String PERSON_BIO_SNAPSHOT_TABLE = "person_bio_snapshot";
	public static final String PERSON_SNAPSHOT_TABLE = "person_snapshot";
	public static final String PET_TABLE = "pet";
	public static final String PET_SNAPSHOT_TABLE = "pet_snapshot";
	public static final String PET_TYPE_TABLE = "pet_type";
	public static final String PET_TYPE_TEXT_TABLE = "pet_type_text";
	public static final String PET_WEIGHT_TABLE = "pet_weight";
	public static final String PET_WEIGHT_TEXT_TABLE = "pet_weight_text";
	public static final String PHONE_TABLE = "phone";
	public static final String PHONE_FORM_TABLE = "phone_form";
	public static final String PHONE_SNAPSHOT_TABLE = "phone_snapshot";
	public static final String POSITION_TABLE = "position";
	public static final String POSITION_TEXT_TABLE = "position_text";
	public static final String PROSPECT_STATUS_TABLE = "prospect_status";
	public static final String PROSPECT_STATUS_TEXT_TABLE = "prospect_status_text";
	public static final String REFUND_POLICY_GROUP_HEADER_TABLE = "refund_policy_group_header";
	public static final String REFUND_POLICY_GROUP_ITEM_TABLE = "refund_policy_group_item";
	public static final String REFUND_POLICY_GROUP_TEXT_TABLE = "refund_policy_group_text";
	public static final String REFUND_POLICY_OWNER_TABLE = "refund_policy_owner";
	public static final String REFUND_POLICY_STORE_TABLE = "refund_policy_store";
	public static final String REFUND_POLICY_TABLE = "refund_policy";
	public static final String REFUND_POLICY_TEXT_TABLE = "refund_policy_text";
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
	public static final String STAT_CUSTOMER_PROFILE_MONTH_TABLE = "stat_customer_profile_month";
	public static final String STAT_CUSTOMER_PROFILE_MONTH_LIVE_TABLE = "vw_stats_customer_profile_month";
	public static final String STAT_CUSTOMER_SCHEDULE_MONTH_TABLE = "stat_customer_schedule_month";
	public static final String STAT_CUSTOMER_SCHEDULE_MONTH_LIVE_TABLE = "vw_stats_customer_schedule_month";
	public static final String STAT_OWNER_ORDER_MONTH_TABLE = "stat_owner_order_month";
	public static final String STAT_OWNER_ORDER_MONTH_LIVE_TABLE = "vw_stats_owner_order_month";
	public static final String STAT_OWNER_SCHEDULE_MONTH_TABLE = "stat_owner_schedule_month";
	public static final String STAT_OWNER_SALE_TABLE = "stat_owner_sale";
	public static final String STAT_OWNER_SALE_LIVE_TABLE = "vw_stats_owner_sale";
	public static final String STAT_OWNER_STORE_MONTH_TABLE = "stat_owner_store_month";
	public static final String STAT_OWNER_STORE_MONTH_LIVE_TABLE = "vw_stats_owner_store_month";
	public static final String STAT_OWNER_USER_MONTH_TABLE = "stat_owner_user_month";
	public static final String STAT_OWNER_USER_MONTH_LIVE_TABLE = "vw_stats_owner_user_month";
	public static final String STAT_STORE_ORDER_DAY_LIVE_TABLE = "vw_stats_store_order_day";
	public static final String STAT_STORE_ORDER_DAY_TABLE = "stat_store_order_day";	
	public static final String STAT_STORE_ORDER_MONTH_LIVE_TABLE = "vw_stats_store_order_month";
	public static final String STAT_STORE_ORDER_MONTH_TABLE = "stat_store_order_month";
	public static final String STAT_STORE_PROFILE_MONTH_TABLE = "stat_store_profile_month";
	public static final String STAT_STORE_PROFILE_MONTH_LIVE_TABLE = "vw_stats_store_profile_month";	
	public static final String STAT_STORE_SCHEDULE_DASH_LIVE_TABLE = "vw_stats_store_schedule_dash";
	public static final String STAT_STORE_SCHEDULE_DAY_TABLE = "stat_store_schedule_day";
	public static final String STAT_STORE_SCHEDULE_DAY_LIVE_TABLE = "vw_stats_store_schedule_day";
	public static final String STAT_STORE_SCHEDULE_MONTH_TABLE = "stat_store_schedule_month";
	public static final String STAT_STORE_SCHEDULE_MONTH_LIVE_TABLE = "vw_stats_store_schedule_month";
	public static final String STAT_USER_ORDER_YEAR_AGGR_TABLE = "stat_user_order_year";
	public static final String STAT_USER_ORDER_YEAR_LIVE_TABLE = "vw_stat_user_order_year";
	public static final String STAT_USER_ORDER_YEAR_STGN_TABLE = "stat_user_order_year_staging";
	public static final String STAT_USER_STORE_AGGR_TABLE = "stat_user_store";
	public static final String STAT_USER_STORE_LIVE_TABLE = "vw_stat_user_store";
	public static final String STAT_USER_STORE_STGN_TABLE = "stat_user_store_staging";
	public static final String STATE_TABLE = "state";
	public static final String STATE_TEXT_TABLE = "state_text";
	public static final String STORE_TABLE = "store";
	public static final String STORE_FAVORITE_TABLE = "store_favorite";
	public static final String STORE_PROSPECT_TABLE = "store_prospect";
	public static final String STORE_SNAPSHOT_TABLE = "store_snapshot";
	public static final String STORE_TEXT_TABLE = "store_text";
	public static final String STORE_TEXT_SNAPSHOT_TABLE = "store_text_snapshot";
	public static final String STORE_LD_TABLE = "store_leave_time";
	public static final String STORE_LT_TABLE = "store_lunch_time";
	public static final String STORE_WT_TABLE = "store_working_time";
	public static final String STORE_LT_SNAPSHOT_TABLE = "store_lunch_time_snapshot";
	public static final String STORE_WT_SNAPSHOT_TABLE = "store_working_time_snapshot";
	public static final String SYS_EMAIL_TABLE = "sys_email";
	public static final String SYS_EMAIL_BODY_TABLE = "sys_email_body";
	public static final String SYS_FILE_IMG_TABLE = "sys_file_image";
	public static final String SYS_FILE_IMG_SNAPSHOT_TABLE = "sys_file_image_snapshot";
	public static final String SYS_MESSAGE_TABLE = "sys_message";
	public static final String SYS_CONFIG_TABLE = "sys_config";	
	public static final String SYS_ENVIRONMENT_TABLE = "sys_environment";
	public static final String UNIT_TABLE = "measure_unit";
	public static final String UNIT_TEXT_TABLE = "measure_unit_text";
	public static final String USER_TABLE = "user";
	public static final String USER_CATEG_TABLE = "user_categ";
	public static final String USER_CATEG_TEXT_TABLE = "user_categ_text";
	public static final String USER_PASSWORD_TABLE = "user_password";
	public static final String USER_SNAPSHOT_TABLE = "user_snapshot";
	public static final String WEBHOOK_PAGARME_TABLE = "webhook_pagarme";
	public static final String WEEKDAY_TABLE = "weekday";
	public static final String WEEKDAY_TEXT_TABLE = "weekday_text";
	
	
	
	
    //Views
	public static final String ADDRESS_DEFAULT_VIEW = "view_address_default";
	public static final String ADDRESS_FORM_SEARCH_VIEW = "view_address_form_search";
	public static final String ADDRESS_SEARCH_VIEW = "view_address_search";
	public static final String ADDRESS_SNAPSHOT_SEARCH_VIEW = "view_address_snapshot_search";
	public static final String AREA_PHONE_SEARCH_VIEW = "view_area_phone_search";
	public static final String BANK_ACCOUNT_SEARCH_VIEW = "view_bank_account_search";	
	public static final String BANK_SEARCH_VIEW = "view_bank_search";
	public static final String BANK_ACCOUNT_TYPE_SEARCH_VIEW = "view_bank_account_type_search";
	public static final String BANK_HOLDER_TYPE_SEARCH_VIEW = "view_bank_holder_type_search";
	public static final String BUSINESS_AREA_SEARCH_VIEW = "view_business_area_search";
	public static final String CALENDAR_DATE_SEARCH_VIEW = "view_calendar_date_search";
	public static final String CALENDAR_MONTH_SEARCH_VIEW = "view_calendar_month_search";
	public static final String CART_ITM_CATEG_SEARCH_VIEW = "view_shop_cart_categ_search";
	public static final String CART_ITM_SEARCH_VIEW = "view_shop_cart_item_search";
	public static final String CART_RESERVE_VIEW = "view_cart_reserve";
	public static final String COMPANY_LIST_VIEW = "view_company_list";
	public static final String COMP_CONFLICT_VIEW = "view_company_conflict";
	public static final String COMP_SEARCH_VIEW = "view_company_search";
	public static final String COUNTRY_LEGAL_SEARCH_VIEW = "view_country_legal_search";
	public static final String COUNTRY_PHONE_SEARCH_VIEW = "view_country_phone_search";
	public static final String COUNTRY_SEARCH_VIEW = "view_country_search";
	public static final String CREDIT_CARD_SEARCH_VIEW = "view_pay_credit_card_search";
	public static final String CURRENCY_SEARCH_VIEW = "view_currency_unit_search";
	public static final String CUS_LIST_VIEW = "view_customer_list";
	public static final String CUS_SEARCH_VIEW = "view_customer_search";
	public static final String DAYPART_SEARCH_VIEW = "view_dayparting_search";
	public static final String DISCOUNT_STORE_SEARCH_VIEW = "view_discount_store_search";
	public static final String EMP_LD_RANGE_VIEW = "employee_leave_time_range_view";
	public static final String EMP_LD_SEARCH_VIEW = "employee_leave_time_search_view";
	public static final String EMP_LIST_VIEW = "view_employee_list";
	public static final String EMP_MAT_SEARCH_VIEW = "view_employee_material_search";
	public static final String EMP_SEARCH_VIEW = "view_employee_search";
	public static final String EMP_LT_RANGE_VIEW = "view_employee_lunch_time_range";
	public static final String EMP_WT_CONFLICT_VIEW = "view_employee_working_time_conflict";
	public static final String EMP_WT_OUTLIER_VIEW = "view_employee_working_time_outlier";
	public static final String EMP_WTIME_RANGE_VIEW = "view_employee_wtime_range";
	public static final String EMP_LT_SEARCH_VIEW = "view_employee_lunch_time_search";
	public static final String EMP_WT_SEARCH_VIEW = "view_employee_working_time_search";
	public static final String EMPOS_LIST_VIEW = "view_employee_position_list";
	public static final String EMPOS_SEARCH_VIEW = "view_employee_position_search";
	public static final String FILE_DOC_TYPE_SEARCH_VIEW = "view_file_doc_type_search";
	public static final String FEE_CATEG_SEARCH_VIEW = "view_fee_categ_search";
	public static final String FILE_IMG_LIST_VIEW = "view_file_image_list";
	public static final String FILE_IMG_SEARCH_VIEW = "view_file_image_search";
	public static final String GENDER_SEARCH_VIEW = "view_gender_search";
	public static final String LANGUAGE_SEARCH_VIEW = "view_language_search";
	public static final String MAT_CATEG_SEARCH_VIEW = "view_material_category_search";
	public static final String MAT_GROUP_SEARCH_VIEW = "view_material_group_search";
	public static final String MAT_LIST_VIEW = "view_material_list";
	public static final String MAT_MOVEMENT_SEARCH_VIEW = "view_material_movement_search";
	public static final String MAT_STOCK_SEARCH_VIEW = "view_material_stock_search";
	public static final String MAT_STORE_SEARCH_VIEW = "view_material_store_search";
	public static final String MAT_TEXT_SEARCH_VIEW = "view_material_text_search";
	public static final String MAT_TEXT_DEFAULT_VIEW = "view_material_text_default";
	public static final String MAT_TYPE_SEARCH_VIEW = "view_material_type_search";
	public static final String MAT_SEARCH_VIEW = "view_material_search";
	public static final String MAT_SUBGROUP_SEARCH_VIEW = "view_material_subgroup_search";
	public static final String MAT_UNIT_SEARCH_VIEW = "view_measure_unit_search";
	public static final String MONTH_TEXT_SEARCH_VIEW = "view_month_text_search";
	public static final String MOON_PHASE_SEARCH_VIEW = "view_moon_phase_search";
	public static final String OWNER_LIST_VIEW = "view_owner_list";
	public static final String OWNER_SEARCH_VIEW = "view_owner_search";
	public static final String ORDER_LIST_VIEW = "view_order_list";
	public static final String ORDER_ITM_LIST_VIEW = "view_order_item_list";
	public static final String ORDER_ITM_SEARCH_VIEW = "view_order_item_search";
	public static final String ORDER_RESERVE_VIEW = "view_order_reserve";
	public static final String ORDER_SEARCH_VIEW = "view_order_search";
	public static final String ORDER_STATUS_SEARCH_VIEW = "view_order_status_search";
	public static final String PAY_CUS_SEARCH_VIEW = "view_pay_customer_search";
	public static final String PAY_ORDER_HDR_LIST_VIEW = "view_pay_order_header_list";
	public static final String PAY_ORDER_HDR_SEARCH_VIEW = "view_pay_order_header_search";
	public static final String PAY_ORDER_ITM_LIST_VIEW = "view_pay_order_item_list";
	public static final String PAY_ORDER_ITM_SEARCH_VIEW = "view_pay_order_item_search";
	public static final String PAY_PARTNER_COUNTRY_SEARCH_VIEW = "view_pay_partner_country_search";
	public static final String PAY_PARTNER_MARKETPLACE_SEARCH_VIEW = "view_pay_partner_marketplace_search";
	public static final String PAY_PARTNER_STORE_VIEW = "view_pay_partner_store";
	public static final String PAY_PARTNER_STORE_SEARCH_VIEW = "view_pay_partner_store_search";
	public static final String PAYMENT_VIEW = "view_payment";
	public static final String PAYMENT_STATUS_SEARCH_VIEW = "view_payment_status_search";	
	public static final String PAY_PARTNER_DEFAULT_VIEW = "view_pay_partner_default";	
	public static final String PERSON_BIO_SEARCH_VIEW = "view_person_bio_search";
	public static final String PERSON_LIST_VIEW = "view_person_list";
	public static final String PERSON_SEARCH_VIEW = "view_person_search";
	public static final String PET_DEFAULT_VIEW = "view_pet_default";
	public static final String PET_SEARCH_VIEW = "view_pet_search";
	public static final String PET_TYPE_SEARCH_VIEW = "view_pet_type_search";
	public static final String PET_WEIGHT_SEARCH_VIEW = "view_pet_weight_search";
	public static final String PHONE_DEFAULT_VIEW = "view_phone_default";
	public static final String PHONE_SEARCH_VIEW = "view_phone_search";
	public static final String PHONE_SNAPSHOT_SEARCH_VIEW = "view_phone_snapshot_search";
	public static final String PLANING_DATA_VIEW = "planing_data_list";
	public static final String PROSPECT_STATUS_SEARCH_VIEW = "view_prospect_status_search";
	public static final String REFUND_VIEW = "view_refund";
	public static final String REFUND_POLICY_GROUP_ITEM_SEARCH_VIEW = "view_refund_policy_group_item_search";
	public static final String REFUND_POLICY_GROUP_HEADER_SEARCH_VIEW = "view_refund_policy_group_header_search";
	public static final String REFUND_POLICY_STORE_SEARCH_VIEW = "view_refund_policy_store_search";
	public static final String SCHEDULE_AUTH_VIEW = "view_auth_search";
	public static final String SCHEDULE_DAY_VIEW = "view_schedule_day";
	public static final String SCHEDULE_LIST_VIEW = "view_list_search";
	public static final String SCHEDULE_RANGE_VIEW = "view_schedule_range";
	public static final String SCHEDULE_RESERVE_VIEW = "view_schedule_reserve";
	public static final String SCHEDULE_SEARCH_VIEW = "view_schedule_search";
	public static final String STAT_OWNER_ORDER_MONTH_SEARCH_VIEW = "view_owner_order_month_search";
	public static final String STAT_OWNER_SCHEDULE_MONTH_SEARCH_VIEW = "view_owner_schedule_month_search";
	public static final String STAT_OWNER_STORE_MONTH_SEARCH_VIEW = "view_owner_store_month_search";
	public static final String STAT_OWNER_USER_MONTH_SEARCH_VIEW = "view_owner_user_month_search";	
	public static final String STAT_USER_ORDER_YEAR_AGGR_SEARCH_VIEW = "view_user_order_year_search";
	public static final String STAT_USER_ORDER_YEAR_LIVE_SEARCH_VIEW = "view_stat_user_order_year_search";
	public static final String STAT_USER_ORDER_YEAR_STGN_SEARCH_VIEW = "view_stat_user_order_year_staging_search";
	public static final String STATE_SEARCH_VIEW = "view_state_search";
	public static final String STORE_AUTH_VIEW = "store_auth_view";
	public static final String STORE_FAVORITE_SEARCH_VIEW = "view_store_favorite_search";
	public static final String STORE_LD_RANGE_VIEW = "store_leave_time_range_view";
	public static final String STORE_LD_SEARCH_VIEW = "view_store_leave_time_search";
	public static final String STORE_LIST_VIEW = "view_store_list";
	public static final String STORE_MANAGER_VIEW = "view_store_manager";
	public static final String STORE_NEARBY_VIEW = "view_nearby_list";
	public static final String STORE_PROSPECT_SEARCH_VIEW = "view_store_prospect";
	public static final String STORE_SEARCH_VIEW = "view_store_search";
	public static final String STORE_TEXT_DEFAULT_VIEW = "view_store_text_default";
	public static final String STORE_TEXT_SEARCH_VIEW = "view_store_text_search";
	public static final String STORE_WTIME_RANGE_VIEW = "view_store_wtime_range";
	public static final String STORE_LTIME_SEARCH_VIEW = "view_store_ltime_search";
	public static final String STORE_WTIME_SEARCH_VIEW = "view_store_wtime_search";
	public static final String SYS_DISTRICT_SEARCH_DEFAULT_VIEW = "view_owner_district_search";
	public static final String SYS_FILE_IMG_SEARCH_VIEW = "view_sys_file_image_search";
	public static final String SYS_OWNER_SIGNUP_VIEW = "view_sys_owner_signup";	
	public static final String SYS_STORE_BUSINESS_CONTENT_VIEW = "view_sys_store_business_content";
	public static final String SYS_STORE_PARTITIONING_VIEW = "view_sys_store_partitioning";
	public static final String SYS_STORE_SIGNUP_VIEW = "view_sys_store_signup";
	public static final String TIMEZONE_SEARCH_VIEW = "view_timezone_search";
	public static final String USER_LIST_VIEW = "view_user_list";
	public static final String USER_PASSWORD_SEARCH_VIEW = "view_user_password_search";
	public static final String USER_SEARCH_VIEW = "view_user_search";
	public static final String USERNAME_VIEW = "view_username";
	public static final String WEEKDAY_SEARCH_VIEW = "view_weekday_search";
}
