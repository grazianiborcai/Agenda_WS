package br.com.gda.employee.dao;

import java.util.List;

import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStmtBuilder;

final class EmpWorkTimeBuilderSelect extends EmpStmtBuilderAbstract<EmpWorkTimeInfo> {
	private EmpWorkTimeBuilderWhere whereBuilder;
	
	public EmpWorkTimeBuilderSelect(String schemaName, EmpWorkTimeInfo workingTime) {
		super(schemaName, workingTime);
	}
	
	
	
	@Override protected String buildTableNameHook() {
		return EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE;
	}
	
	
	
	@Override protected String buildWhereClauseHook() {
		this.whereBuilder = new EmpWorkTimeBuilderWhere(this.infoRecord);		
		return whereBuilder.generateClause();
	}
	
	
	
	@Override protected List<String> buildColumnsHook() {
		List<String> resultColumns = EmpDbTableColumn.getTableColumns(EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE);
		return resultColumns;
	}
	
	
	
	@Override protected SqlStmtBuilder buildStatementHook() {		
		return SqlStmtBuilder.factory(SqlOperation.SELECT, builderOption);
	}
}