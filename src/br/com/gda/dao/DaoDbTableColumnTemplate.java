package br.com.gda.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import br.com.gda.common.SystemMessage;

public class DaoDbTableColumnTemplate implements DaoDbTableColumn {
	protected static final boolean IS_PRIMARY_KEY = true;	
	protected static final boolean IS_LOOKUP_COLUMN = true;
	protected static final boolean IS_AUTO_INCREMENTED = true;
	protected static final boolean NEGATIVE = false;
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	protected DaoDbTableColumnTemplate() {		
		buildTableColumns();
	}
	
	
	
	private void buildTableColumns() {
		tableColumns = buildTableColumnsHook();
	}
	
	
	
	protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public List<String> getTableNamesAsList() {
		List<String> allTableNames = new ArrayList<>();		
		Iterator<Entry<String, List<DaoColumn>>> itrMapEntry = tableColumns.entrySet().iterator();
		
		while (itrMapEntry.hasNext()) {
			Entry<String, List<DaoColumn>> eachEntry = itrMapEntry.next();
			String tableName = eachEntry.getKey();
			allTableNames.add(tableName);
		}
		
		return allTableNames;
	}
	
	
	
	@Override public List<DaoColumn> getTableColumnsAsList(String tableName) {
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
