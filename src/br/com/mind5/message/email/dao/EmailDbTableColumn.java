package br.com.mind5.message.email.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class EmailDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_EMAIL_SENDER = DaoDbField.COL_EMAIL_SENDER;
	public static final String COL_SENDER_PASSWORD = DaoDbField.COL_SENDER_PASSWORD;
	public static final String COL_SMTP_HOST_NAME = DaoDbField.COL_SMTP_HOST_NAME;
	public static final String COL_SMTP_PORT = DaoDbField.COL_SMTP_PORT;	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public EmailDbTableColumn() {
		super(EmailDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildEmailTable();	
		return tableColumns;
	}
	
	
	
	private void buildEmailTable() {
		final String TABLE_NAME = DaoDbTable.SYS_EMAIL_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_SMTP_HOST_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_SMTP_PORT;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_EMAIL_SENDER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_SENDER_PASSWORD;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
