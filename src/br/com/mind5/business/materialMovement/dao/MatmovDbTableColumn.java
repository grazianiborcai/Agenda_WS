package br.com.mind5.business.materialMovement.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class MatmovDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_LANGUAGE = "language";
	public static final String COL_COD_MAT_MOV = "cod_mat_mov";
	public static final String COL_COD_MAT_MOV_TYPE = "cod_mat_mov_type";
	public static final String COL_COD_MATERIAL = "cod_material";
	public static final String COL_COD_OWNER = "cod_owner";	
	public static final String COL_COD_STORE = "cod_store";
	public static final String COL_LAST_CHANGED = "last_changed";
	public static final String COL_LAST_CHANGED_BY = "last_changed_by";
	public static final String COL_POSTING_DATE = "posting_date";
	public static final String COL_QUANTITY = "quantity";

	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public MatmovDbTableColumn() {
		super(MatmovDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();
		
		buildMatmovTable();
		
		return tableColumns;
	}
	
	
	
	private void buildMatmovTable() {
		final String TABLE_NAME = DaoDbTable.MAT_MOVEMENT_TABLE;
		
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
		oneColumn.columnName = COL_COD_MAT_MOV;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = IS_AUTO_INCREMENTED;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_MAT_MOV_TYPE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_MATERIAL;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_STORE;
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
		oneColumn.columnName = COL_LAST_CHANGED_BY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_QUANTITY;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_POSTING_DATE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.LANGUAGE_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
