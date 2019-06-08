package br.com.gda.business.orderReserve.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.business.order.dao.OrderDbTableColumn;
import br.com.gda.business.orderItem.dao.OrderemDbTableColumn;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnTemplate;
import br.com.gda.dao.common.DaoDbTable;

public final class OrderveDbTableColumn extends DaoDbTableColumnTemplate {	
	public static final String COL_BEGIN_TIME = OrderemDbTableColumn.COL_BEGIN_TIME;
	public static final String COL_COD_CUSTOMER = OrderDbTableColumn.COL_COD_CUSTOMER;
	public static final String COL_COD_EMPLOYEE = OrderemDbTableColumn.COL_COD_EMPLOYEE;
	public static final String COL_COD_MATERIAL = OrderemDbTableColumn.COL_COD_MATERIAL;
	public static final String COL_COD_ORDER_STATUS = OrderDbTableColumn.COL_COD_ORDER_STATUS;
	public static final String COL_COD_OWNER = OrderemDbTableColumn.COL_COD_OWNER;
	public static final String COL_COD_ORDER = OrderDbTableColumn.COL_COD_ORDER;
	public static final String COL_COD_STORE = OrderemDbTableColumn.COL_COD_STORE;
	public static final String COL_COD_USER = OrderDbTableColumn.COL_COD_USER;
	public static final String COL_DATE = OrderemDbTableColumn.COL_DATE;
	public static final String COL_END_TIME = OrderemDbTableColumn.COL_END_TIME;	
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public OrderveDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();	
		buildOrderReserveTable();
		return tableColumns;
	}
	
	
	
	private void buildOrderReserveTable() {
		final String TABLE_NAME = DaoDbTable.ORDER_ITM_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.ORDER_HDR_TABLE;
		oneColumn.columnName = COL_COD_ORDER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.ORDER_HDR_TABLE;
		oneColumn.columnName = COL_COD_CUSTOMER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_STORE;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_MATERIAL;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_BEGIN_TIME;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_END_TIME;
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
		oneColumn.columnName = COL_COD_EMPLOYEE;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.ORDER_HDR_TABLE;
		oneColumn.columnName = COL_COD_USER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.ORDER_HDR_TABLE;
		oneColumn.columnName = COL_COD_ORDER_STATUS;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(DaoDbTable.ORDER_RESERVE_VIEW, columns);
	}
}
