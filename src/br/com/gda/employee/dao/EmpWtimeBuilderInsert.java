package br.com.gda.employee.dao;

import java.util.List;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStmtBuilder;

final class EmpWtimeBuilderInsert extends EmpStmtBuilderAbstract<EmpWTimeInfo> {	
	
	public EmpWtimeBuilderInsert(String schemaName, EmpWTimeInfo workingTime) {
		super(schemaName, workingTime);
	}
	
	
	
	@Override protected String buildTableNameHook() {
		return EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE;
	}
	
	
	
	@Override protected List<SqlColumn> buildColumnsHook() {
		List<SqlColumn> resultColumns = EmpDbTableColumn.getTableColumnsAsList(EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE);
		return resultColumns;
	}
	
	
	
	@Override protected SqlStmtBuilder buildStatementHook() {		
		return SqlStmtBuilder.factory(SqlOperation.INSERT, builderOption);
	}
}