package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class StoronagrDaoDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_CALMONTH = DaoDbField.COL_CALMONTH;
	public static final String COL_CITY = DaoDbField.COL_CITY;
	public static final String COL_COD_COUNTRY = DaoDbField.COL_COD_COUNTRY;
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER;
	public static final String COL_COD_STORE = DaoDbField.COL_COD_STORE;
	public static final String COL_COUNT_ORDER_CANCELLED_MONTH = DaoDbField.COL_COUNT_ORDER_CANCELLED_MONTH;
	public static final String COL_COUNT_ORDER_CANCELLED_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_ORDER_CANCELLED_MONTH_LAST_YEAR;
	public static final String COL_COUNT_ORDER_CREATED_MONTH = DaoDbField.COL_COUNT_ORDER_CREATED_MONTH;
	public static final String COL_COUNT_ORDER_CREATED_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_ORDER_CREATED_MONTH_LAST_YEAR;
	public static final String COL_COUNT_ORDER_PAID_MONTH = DaoDbField.COL_COUNT_ORDER_PAID_MONTH;
	public static final String COL_COUNT_ORDER_PAID_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_ORDER_PAID_MONTH_LAST_YEAR;
	public static final String COL_COUNT_ORDER_PLACED_MONTH = DaoDbField.COL_COUNT_ORDER_PLACED_MONTH;
	public static final String COL_COUNT_ORDER_PLACED_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_ORDER_PLACED_MONTH_LAST_YEAR;
	public static final String COL_COUNT_ORDER_TOTAL_MONTH = DaoDbField.COL_COUNT_ORDER_TOTAL_MONTH;
	public static final String COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR;
	public static final String COL_COUNT_ORDER_WAITING_MONTH = DaoDbField.COL_COUNT_ORDER_WAITING_MONTH;
	public static final String COL_COUNT_ORDER_WAITING_MONTH_LAST_YEAR = DaoDbField.COL_COUNT_ORDER_WAITING_MONTH_LAST_YEAR;
	public static final String COL_LAST_CHANGED = DaoDbField.COL_LAST_CHANGED;
	public static final String COL_MONTH = DaoDbField.COL_MONTH;
	public static final String COL_STATE_PROVINCE = DaoDbField.COL_STATE_PROVINCE;
	public static final String COL_TOTAL_FEE_CANCELLED_MONTH = DaoDbField.COL_TOTAL_FEE_CANCELLED_MONTH;
	public static final String COL_TOTAL_FEE_CANCELLED_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_FEE_CANCELLED_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_FEE_CREATED_MONTH = DaoDbField.COL_TOTAL_FEE_CREATED_MONTH;
	public static final String COL_TOTAL_FEE_CREATED_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_FEE_CREATED_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_FEE_MONTH = DaoDbField.COL_TOTAL_FEE_MONTH;
	public static final String COL_TOTAL_FEE_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_FEE_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_FEE_PAID_MONTH = DaoDbField.COL_TOTAL_FEE_PAID_MONTH;
	public static final String COL_TOTAL_FEE_PAID_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_FEE_PAID_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_FEE_PLACED_MONTH = DaoDbField.COL_TOTAL_FEE_PLACED_MONTH;
	public static final String COL_TOTAL_FEE_PLACED_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_FEE_PLACED_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_FEE_WAITING_MONTH = DaoDbField.COL_TOTAL_FEE_WAITING_MONTH;
	public static final String COL_TOTAL_FEE_WAITING_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_FEE_WAITING_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_SALE_CANCELLED_MONTH = DaoDbField.COL_TOTAL_SALE_CANCELLED_MONTH;
	public static final String COL_TOTAL_SALE_CANCELLED_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_SALE_CANCELLED_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_SALE_CREATED_MONTH = DaoDbField.COL_TOTAL_SALE_CREATED_MONTH;
	public static final String COL_TOTAL_SALE_CREATED_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_SALE_CREATED_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_SALE_MONTH = DaoDbField.COL_TOTAL_SALE_MONTH;
	public static final String COL_TOTAL_SALE_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_SALE_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_SALE_PAID_MONTH = DaoDbField.COL_TOTAL_SALE_PAID_MONTH;
	public static final String COL_TOTAL_SALE_PAID_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_SALE_PAID_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_SALE_PLACED_MONTH = DaoDbField.COL_TOTAL_SALE_PLACED_MONTH;
	public static final String COL_TOTAL_SALE_PLACED_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_SALE_PLACED_MONTH_LAST_YEAR;
	public static final String COL_TOTAL_SALE_WAITING_MONTH = DaoDbField.COL_TOTAL_SALE_WAITING_MONTH;
	public static final String COL_TOTAL_SALE_WAITING_MONTH_LAST_YEAR = DaoDbField.COL_TOTAL_SALE_WAITING_MONTH_LAST_YEAR;
	public static final String COL_YEAR = DaoDbField.COL_YEAR;
	
	
	public StoronagrDaoDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		final String TABLE_NAME = DaoDbTable.STAT_STORE_ORDER_MONTH_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();
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
		oneColumn.columnName = COL_CALMONTH;
		oneColumn.isPK = IS_PRIMARY_KEY;
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
		oneColumn.columnName = COL_COUNT_ORDER_CANCELLED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_WAITING_MONTH;
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
		oneColumn.columnName = COL_COUNT_ORDER_PLACED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_CREATED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_PAID_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_CANCELLED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_CREATED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_PAID_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_PLACED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_WAITING_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_CANCELLED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_CREATED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_PAID_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_PLACED_MONTH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_WAITING_MONTH;
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
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_CANCELLED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_WAITING_MONTH_LAST_YEAR;
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
		oneColumn.columnName = COL_COUNT_ORDER_PLACED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_CREATED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COUNT_ORDER_PAID_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_CANCELLED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_CREATED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_PAID_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_PLACED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_SALE_WAITING_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_CANCELLED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_CREATED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_PAID_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_PLACED_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_TOTAL_FEE_WAITING_MONTH_LAST_YEAR;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);


		Hashtable<String, List<DaoColumn>> results = new Hashtable<>();
		results.put(TABLE_NAME, columns);
		return results;
	}
}
