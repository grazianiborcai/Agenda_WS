package br.com.mind5.security.username.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class UsernameDbTableColumn extends DaoDbTableColumnTemplate {	
	public static final String COL_COD_AUTH_GROUP = "cod_auth_group";
	public static final String COL_COD_OWNER = "cod_owner";
	public static final String COL_COD_USER = "cod_user";
	public static final String COL_COD_USER_CATEG = "cod_user_categ";	
	public static final String COL_RECORD_MODE = "record_mode";	
	public static final String COL_USERNAME = "username";
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	
	public UsernameDbTableColumn() {
		super(UsernameDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildUsernameTable();		
		return tableColumns;
	}
	
	
	
	private void buildUsernameTable() {
		final String TABLE_NAME = DaoDbTable.USERNAME_VIEW;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.USER_TABLE;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.USER_TABLE;
		oneColumn.columnName = COL_USERNAME;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.USER_TABLE;
		oneColumn.columnName = COL_COD_USER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.USER_TABLE;
		oneColumn.columnName = COL_RECORD_MODE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.USER_TABLE;
		oneColumn.columnName = COL_COD_USER_CATEG;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.USER_TABLE;
		oneColumn.columnName = COL_COD_AUTH_GROUP;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
