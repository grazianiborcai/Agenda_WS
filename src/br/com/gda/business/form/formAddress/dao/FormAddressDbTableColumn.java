package br.com.gda.business.form.formAddress.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnTemplate;
import br.com.gda.dao.common.DaoDbTable;

public final class FormAddressDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_COUNTRY = "country";
	public static final String COL_COD_FORM = "cod_form";
	
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public FormAddressDbTableColumn() {
		super(FormAddressDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();
		addressFormTable();
		
		return tableColumns;
	}
	
	
	
	private void addressFormTable() {
		final String TABLE_NAME = DaoDbTable.ADDRESS_FORM_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_COUNTRY;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_FORM;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
