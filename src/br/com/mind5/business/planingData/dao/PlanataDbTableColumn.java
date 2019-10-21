package br.com.mind5.business.planingData.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.dao.EmpwotmDbTableColumn;
import br.com.mind5.business.material.dao.MatDbTableColumn;
import br.com.mind5.business.store.dao.StoreDbTableColumn;
import br.com.mind5.business.storeWorkTime.dao.StowotmDbTableColumn;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class PlanataDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_BEGIN_TIME = EmpwotmDbTableColumn.COL_BEGIN_TIME;
	public static final String COL_COD_EMPLOYEE = EmpwotmDbTableColumn.COL_COD_EMPLOYEE;
	public static final String COL_COD_MATERIAL = MatDbTableColumn.COL_COD_MATERIAL;
	public static final String COL_COD_OWNER = StoreDbTableColumn.COL_COD_OWNER;
	public static final String COL_COD_STORE = StoreDbTableColumn.COL_COD_STORE;
	public static final String COL_COD_WEEKDAY = StowotmDbTableColumn.COL_COD_WEEKDAY;
	public static final String COL_END_TIME = EmpwotmDbTableColumn.COL_END_TIME;
	public static final String COL_RECORD_MODE = StoreDbTableColumn.COL_RECORD_MODE;	
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public PlanataDbTableColumn() {
		super(PlanataDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildEmployeeListTable();		
		return tableColumns;
	}
	
	
	
	private void buildEmployeeListTable() {
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.STORE_TABLE;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.STORE_TABLE;
		oneColumn.columnName = COL_COD_STORE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.STORE_WT_TABLE;
		oneColumn.columnName = COL_COD_WEEKDAY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.EMP_WT_TABLE;
		oneColumn.columnName = COL_BEGIN_TIME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.EMP_WT_TABLE;
		oneColumn.columnName = COL_END_TIME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.EMP_WT_TABLE;
		oneColumn.columnName = COL_COD_EMPLOYEE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.MAT_TABLE;
		oneColumn.columnName = COL_COD_MATERIAL;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.STORE_TABLE;
		oneColumn.columnName = COL_RECORD_MODE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(DaoDbTable.PLANING_DATA_VIEW, columns);
	}
}
