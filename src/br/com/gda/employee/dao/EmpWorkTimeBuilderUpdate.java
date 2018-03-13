package br.com.gda.employee.dao;

import java.util.List;

import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStmtBuilder;

final class EmpWorkTimeBuilderUpdate extends EmpStmtBuilderAbstract<EmpWorkTimeInfo> {
	private EmpWorkTimeBuilderWhere whereBuilder;
	
	public EmpWorkTimeBuilderUpdate(String schemaName, EmpWorkTimeInfo workingTime) {
		super(schemaName, workingTime);
	}
	
	
	
	@Override protected String buildTableNameHook() {
		return EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE;
	}
	
	
	
	@Override protected String buildWhereClauseHook() {
		boolean DONT_IGNORE_NULL_CONDITION = false;
		this.whereBuilder = new EmpWorkTimeBuilderWhere(this.infoRecord, DONT_IGNORE_NULL_CONDITION);		
		return whereBuilder.generateClause();
	}
	
	
	
	@Override protected List<String> buildColumnsHook() {
		List<String> resultColumns = EmpDbTableColumn.getTableColumns(EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE);
		return resultColumns;
	}
	
	
	
	@Override protected SqlStmtBuilder buildStatementHook() {		
		return SqlStmtBuilder.factory(SqlOperation.UPDATE, builderOption);
	}
}
