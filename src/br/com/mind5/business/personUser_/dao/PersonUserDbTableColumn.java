package br.com.mind5.business.personUser_.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.business.person.dao.PersonDbTableColumn;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.security.user.dao.UserDbTableColumn;

public final class PersonUserDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_ENTITY_CATEG = PersonDbTableColumn.COL_COD_ENTITY_CATEG;
	public static final String COL_COD_OWNER = PersonDbTableColumn.COL_COD_OWNER;
	public static final String COL_COD_PERSON = PersonDbTableColumn.COL_COD_PERSON;	
	public static final String COL_COD_USER = UserDbTableColumn.COL_COD_USER;
	public static final String COL_CPF = PersonDbTableColumn.COL_CPF;
	public static final String COL_EMAIL = PersonDbTableColumn.COL_EMAIL;
	public static final String COL_RECORD_MODE = PersonDbTableColumn.COL_RECORD_MODE;	
	
	
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	
	public PersonUserDbTableColumn() {
		super(PersonUserDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildPersonUserView();		
		return tableColumns;
	}
	
	
	
	private void buildPersonUserView() {
		final String TABLE_NAME = DaoDbTable.PERSON_TABLE;
		
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
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_ENTITY_CATEG;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_PERSON;
		oneColumn.isPK = NEGATIVE;
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
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_CPF;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_EMAIL;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_RECORD_MODE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(DaoDbTable.PERSON_USER_VIEW, columns);
	}
}
