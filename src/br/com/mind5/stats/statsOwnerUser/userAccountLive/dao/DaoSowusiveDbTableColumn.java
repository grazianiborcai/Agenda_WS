package br.com.mind5.stats.statsOwnerUser.userAccountLive.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoSowusiveDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_CALMONTH = DaoDbField.COL_CALMONTH;
	public static final String COL_CITY = DaoDbField.COL_CITY;
	public static final String COL_COD_COUNTRY = DaoDbField.COL_COD_COUNTRY;
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER;
	public static final String COL_COUNT_ORDER_TOTAL_CUMULATIVE = DaoDbField.COL_COUNT_ORDER_TOTAL_CUMULATIVE;
	public static final String COL_COUNT_ORDER_TOTAL_MONTH = DaoDbField.COL_COUNT_ORDER_TOTAL_MONTH;
	public static final String COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR;
	public static final String COL_COUNT_ORDER_TOTAL_VAR = DaoDbField.COL_COUNT_ORDER_TOTAL_VAR;
	public static final String COL_COUNT_USER_ACTIVE_CUMULATIVE = DaoDbField.COL_COUNT_USER_ACTIVE_CUMULATIVE;
	public static final String COL_COUNT_USER_ACTIVE_MONTH = DaoDbField.COL_COUNT_USER_ACTIVE_MONTH;
	public static final String COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR;
	public static final String COL_COUNT_USER_ACTIVE_VAR = DaoDbField.COL_COUNT_USER_ACTIVE_VAR;
	public static final String COL_COUNT_USER_CREATION_CUMULATIVE = DaoDbField.COL_COUNT_USER_CREATION_CUMULATIVE;
	public static final String COL_COUNT_USER_CREATION_MONTH = DaoDbField.COL_COUNT_USER_CREATION_MONTH;
	public static final String COL_COUNT_USER_CREATION_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_USER_CREATION_MONTH_LAST_YEAR;
	public static final String COL_COUNT_USER_CREATION_VAR = DaoDbField.COL_COUNT_USER_CREATION_VAR;
	public static final String COL_COUNT_USER_ENGAGEMENT_CUMULATIVE = DaoDbField.COL_COUNT_USER_ENGAGEMENT_CUMULATIVE;
	public static final String COL_COUNT_USER_ENGAGEMENT_MONTH = DaoDbField.COL_COUNT_USER_ENGAGEMENT_MONTH;
	public static final String COL_COUNT_USER_ENGAGEMENT_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_USER_ENGAGEMENT_MONTH_LAST_YEAR;
	public static final String COL_COUNT_USER_ENGAGEMENT_MONTH_VAR = DaoDbField.COL_COUNT_USER_ENGAGEMENT_MONTH_VAR;	
	public static final String COL_COUNT_USER_INACTIVE_CUMULATIVE = DaoDbField.COL_COUNT_USER_INACTIVE_CUMULATIVE;	
	public static final String COL_COUNT_USER_INACTIVE_MONTH = DaoDbField.COL_COUNT_USER_INACTIVE_MONTH;
	public static final String COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR;
	public static final String COL_COUNT_USER_INACTIVE_VAR = DaoDbField.COL_COUNT_USER_INACTIVE_VAR;
	public static final String COL_MONTH = DaoDbField.COL_MONTH;
	public static final String COL_STATE_PROVINCE = DaoDbField.COL_STATE_PROVINCE;
	public static final String COL_YEAR = DaoDbField.COL_YEAR;
	
	
	
	public DaoSowusiveDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		final String TABLE_NAME = DaoDbTable.STAT_USER_ACCOUNT_DASH_LIVE_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_CALMONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_COUNTRY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_STATE_PROVINCE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_CITY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_CREATION_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_ACTIVE_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_INACTIVE_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_CREATION_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_CREATION_VAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_ACTIVE_VAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_INACTIVE_VAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_CREATION_CUMULATIVE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_ACTIVE_CUMULATIVE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_INACTIVE_CUMULATIVE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_TOTAL_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_TOTAL_VAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_TOTAL_CUMULATIVE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_ENGAGEMENT_CUMULATIVE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_ENGAGEMENT_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_ENGAGEMENT_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_USER_ENGAGEMENT_MONTH_VAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);


		Hashtable<String, List<DaoColumn>> results = new Hashtable<>();
		results.put(TABLE_NAME, columns);
		return results;
	}
}
