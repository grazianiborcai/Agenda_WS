package br.com.gda.sql;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.business.customer.dao.CusDbTableColumn;
import br.com.gda.business.employee.dao.EmpDbTableColumn;
import br.com.gda.business.employeeLeaveDate.dao.EmpLDateDbTableColumn;
import br.com.gda.business.employeeWorkTime.dao.EmpWTimeDbTableColumn;
import br.com.gda.business.employeeWorkTimeConflict.dao.EmpCoDbTableColumn;
import br.com.gda.business.masterData.dao.MasterDataDbTableColumn;
import br.com.gda.business.material.dao.MatDbTableColumn;
import br.com.gda.business.materialEmployee.dao.MatEmpDbTableColumn;
import br.com.gda.business.materialStore.dao.MatStoreDbTableColumn;
import br.com.gda.business.store.dao.StoreDbTableColumn;
import br.com.gda.business.storeEmployee.dao.StoreEmpDbTableColumn;
import br.com.gda.business.storeLeaveDate.dao.StoreLDateDbTableColumn;
import br.com.gda.business.storeWorkTime.dao.StoreWTimeDbTableColumn;
import br.com.gda.business.storeWorkTimeConflict.dao.StoreCoDbTableColumn;
import br.com.gda.common.SystemMessage;

public final class SqlDbTableColumnAll {
	private static Hashtable<String, List<SqlColumn>> tableColumns;
	
	
	
	static {
		buildTableColumns();
	}
	
	
	
	private static void buildTableColumns() {
		tableColumns = new Hashtable<>();
		
		addTable(new MatDbTableColumn());
		addTable(new MatEmpDbTableColumn());
		addTable(new StoreDbTableColumn());
		addTable(new StoreEmpDbTableColumn());
		addTable(new MasterDataDbTableColumn());
		addTable(new StoreWTimeDbTableColumn());
		addTable(new StoreLDateDbTableColumn());
		addTable(new EmpWTimeDbTableColumn());
		addTable(new EmpLDateDbTableColumn());
		addTable(new EmpCoDbTableColumn());
		addTable(new StoreCoDbTableColumn());
		addTable(new EmpDbTableColumn());
		addTable(new CusDbTableColumn());
		addTable(new MatStoreDbTableColumn());
	}
	
	
	
	private static void addTable(SqlDbTableColumn tblCol) {
		List<String> tblNames = tblCol.getTableNamesAsList();
		
		for (String eachTblName : tblNames) {
			List<SqlColumn> columns = tblCol.getTableColumnsAsList(eachTblName);
			tableColumns.put(eachTblName, columns);
		}
	}
	
	
	
	public static List<SqlColumn> getTableColumnsAsList(String tableName) {
		List<SqlColumn> columns = tableColumns.get(tableName);
		
		if (columns == null)
			throw new IllegalArgumentException(tableName + " " + SystemMessage.TABLE_NOT_FOUND);
		
		
		List<SqlColumn> resultColumns = new ArrayList<>();
		
		for (SqlColumn eachColumn : columns) {
			resultColumns.add(eachColumn);
		}
		
		return resultColumns;
	}
}
