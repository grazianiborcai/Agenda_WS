package br.com.gda.employee.dao;

import java.util.List;

import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStmtBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpWorkTimeBuilderDelete extends EmpStmtBuilderAbstract<EmpWorkTimeInfo> {
	private EmpWorkTimeBuilderWhere whereBuilder;
	
	public EmpWorkTimeBuilderDelete(String schemaName, EmpWorkTimeInfo workingTime) {
		super(schemaName, workingTime);
	}
	
	
	
	@Override protected String buildTableNameHook() {
		return EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE;
	}
	
	
	
	@Override protected String buildWhereClauseHook() {
		boolean DONT_IGNORE_NULL_CONDITION = false;
		SqlWhereBuilderOption option = new SqlWhereBuilderOption();
		option.isIgnoringNull = DONT_IGNORE_NULL_CONDITION;
		
		this.whereBuilder = new EmpWorkTimeBuilderWhere(this.infoRecord, option);		
		return whereBuilder.generateClause();
	}
	
	
	
	@Override protected List<SqlColumn> buildColumnsHook() {
		List<SqlColumn> resultColumns = EmpDbTableColumn.getTableColumnsAsList(EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE);
		return resultColumns;
	}
	
	
	
	@Override protected SqlStmtBuilder buildStatementHook() {		
		return SqlStmtBuilder.factory(SqlOperation.DELETE, builderOption);
	}
}
