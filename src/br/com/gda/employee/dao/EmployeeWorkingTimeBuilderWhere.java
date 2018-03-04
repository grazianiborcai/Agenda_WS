package br.com.gda.employee.dao;

import br.com.gda.employee.info.EmployeeWorkingTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlOperator;
import br.com.gda.sql.SqlWhereBuilder;

final class EmployeeWorkingTimeBuilderWhere {
	private SqlWhereBuilder builder;
	
	
	public EmployeeWorkingTimeBuilderWhere(EmployeeWorkingTimeInfo workingTime) {
		checkArgument(workingTime);		
		builder = SqlWhereBuilder.factory(SqlOperator.EQUAL);
		buildClause(workingTime);
	}
	
	
	
	private void buildClause(EmployeeWorkingTimeInfo workingTime) {
		builder.appendClauseWithAnd("cod_owner", SqlFormatterNumber.numberToString(workingTime.codOwner));
		builder.appendClauseWithAnd("cod_store", SqlFormatterNumber.numberToString(workingTime.codStore));
		builder.appendClauseWithAnd("cod_employee", SqlFormatterNumber.numberToString(workingTime.codEmployee));
		builder.appendClauseWithAnd("record_mode", RecordMode.RECORD_OK);
	}	
	
	
	
	private void checkArgument(EmployeeWorkingTimeInfo workingTime) {
		if (workingTime == null)
			throw new NullPointerException();
	}
	
	
	
	public String generateClause() {
		return builder.generateClause();
	}

	
	
	public boolean checkClauseGeneration() {
		return builder.checkClauseGeneration();
	}
}
