package br.com.mind5.business.form.formPhone.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class FormPhoneDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_COUNTRY = DaoDbField.COL_COD_COUNTRY;
	public static final String COL_COD_FORM = DaoDbField.COL_COD_FORM;
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public FormPhoneDbTableColumn() {
		super(FormPhoneDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();
		addressFormTable();
		
		return tableColumns;
	}
	
	
	
	private void addressFormTable() {
		final String TABLE_NAME = DaoDbTable.PHONE_FORM_TABLE;
		
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
