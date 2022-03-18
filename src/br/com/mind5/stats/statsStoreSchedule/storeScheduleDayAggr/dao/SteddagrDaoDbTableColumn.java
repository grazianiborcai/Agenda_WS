package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class SteddagrDaoDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_CALMONTH = DaoDbField.COL_CALMONTH;
	public static final String COL_CITY = DaoDbField.COL_CITY;
	public static final String COL_COD_COUNTRY = DaoDbField.COL_COD_COUNTRY;
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER;
	public static final String COL_COD_STORE = DaoDbField.COL_COD_STORE;
	public static final String COL_COUNT_SCHEDULE_CANCELLED_DAY = DaoDbField.COL_COUNT_SCHEDULE_CANCELLED_DAY;
	public static final String COL_COUNT_SCHEDULE_CONFIRMED_DAY = DaoDbField.COL_COUNT_SCHEDULE_CONFIRMED_DAY;
	public static final String COL_COUNT_SCHEDULE_TOTAL_DAY = DaoDbField.COL_COUNT_SCHEDULE_TOTAL_DAY;
	public static final String COL_COUNT_SCHEDULE_WAITING_DAY = DaoDbField.COL_COUNT_SCHEDULE_WAITING_DAY;
	public static final String COL_DAY = DaoDbField.COL_DAY;
	public static final String COL_DATE = DaoDbField.COL_DATE;
	public static final String COL_LAST_CHANGED = DaoDbField.COL_LAST_CHANGED;
	public static final String COL_MONTH = DaoDbField.COL_MONTH;
	public static final String COL_STATE_PROVINCE = DaoDbField.COL_STATE_PROVINCE;
	public static final String COL_YEAR = DaoDbField.COL_YEAR;
	
	
	
	public SteddagrDaoDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		final String TABLE_NAME = DaoDbTable.STAT_STORE_SCHEDULE_DAY_TABLE;
		
		List<DaoColumn> columns = new ArrayList<>();
		DaoColumn oneColumn;
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_STORE;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		

		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_DATE;
		oneColumn.isPK = IS_PRIMARY_KEY;
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
		oneColumn.columnName = COL_COUNT_SCHEDULE_CANCELLED_DAY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_SCHEDULE_WAITING_DAY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_SCHEDULE_TOTAL_DAY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
	
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_SCHEDULE_CONFIRMED_DAY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_DAY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_LAST_CHANGED;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);


		Hashtable<String, List<DaoColumn>> results = new Hashtable<>();
		results.put(TABLE_NAME, columns);
		return results;
	}
}
