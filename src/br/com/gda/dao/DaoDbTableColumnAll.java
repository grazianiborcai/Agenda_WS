package br.com.gda.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.business.cart.dao.CartDbTableColumn;
import br.com.gda.business.customer.dao.CusDbTableColumn;
import br.com.gda.business.employee.dao.EmpDbTableColumn;
import br.com.gda.business.employeeLeaveDate.dao.EmpLDateDbTableColumn;
import br.com.gda.business.employeeWorkTime.dao.EmpWTimeDbTableColumn;
import br.com.gda.business.employeeWorkTimeConflict.dao.EmpCoDbTableColumn;
import br.com.gda.business.fee.dao.FeeDbTableColumn;
import br.com.gda.business.masterData.dao.MasterDataDbTableColumn;
import br.com.gda.business.material.dao.MatDbTableColumn;
import br.com.gda.business.materialEmployee.dao.MatEmpDbTableColumn;
import br.com.gda.business.materialStore.dao.MatStoreDbTableColumn;
import br.com.gda.business.owner.dao.OwnerDbTableColumn;
import br.com.gda.business.store.dao.StoreDbTableColumn;
import br.com.gda.business.storeEmployee.dao.StoreEmpDbTableColumn;
import br.com.gda.business.storeLeaveDate.dao.StoreLDateDbTableColumn;
import br.com.gda.business.storeWorkTime.dao.StoreWTimeDbTableColumn;
import br.com.gda.business.storeWorkTimeConflict.dao.StoreCoDbTableColumn;
import br.com.gda.common.SystemMessage;

public final class DaoDbTableColumnAll {
	private static Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	
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
		addTable(new OwnerDbTableColumn());
		addTable(new MatStoreDbTableColumn());
		addTable(new CartDbTableColumn());
		addTable(new FeeDbTableColumn());
	}
	
	
	
	private static void addTable(DaoDbTableColumn tblCol) {
		List<String> tblNames = tblCol.getTableNamesAsList();
		
		for (String eachTblName : tblNames) {
			List<DaoColumn> columns = tblCol.getTableColumnsAsList(eachTblName);
			tableColumns.put(eachTblName, columns);
		}
	}
	
	
	
	public static List<DaoColumn> getTableColumnsAsList(String tableName) {
		List<DaoColumn> columns = tableColumns.get(tableName);
		
		if (columns == null)
			throw new IllegalArgumentException(tableName + " " + SystemMessage.TABLE_NOT_FOUND);
		
		
		List<DaoColumn> resultColumns = new ArrayList<>();
		
		for (DaoColumn eachColumn : columns) {
			resultColumns.add(eachColumn);
		}
		
		return resultColumns;
	}
}
