package br.com.gda.employee.dao;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpWtimeBuilderWhere {
	private SqlWhereBuilder builder;
	
	
	public EmpWtimeBuilderWhere(EmpWTimeInfo workingTime) {
		this(workingTime, new SqlWhereBuilderOption());
	}
	
	
	
	public EmpWtimeBuilderWhere(EmpWTimeInfo workingTime, SqlWhereBuilderOption option) {
		checkArgument(workingTime);		
		builder = SqlWhereBuilder.factory(option);
		buildClause(workingTime);
	}
	
	
	
	private void checkArgument(EmpWTimeInfo workingTime) {
		if (workingTime == null)
			throw new NullPointerException();
	}
	
	
	
	private void buildClause(EmpWTimeInfo workingTime) {
		builder.appendClauseWithAnd("cod_owner", SqlFormatterNumber.numberToString(workingTime.codOwner));
		builder.appendClauseWithAnd("cod_store", SqlFormatterNumber.numberToString(workingTime.codStore));
		builder.appendClauseWithAnd("cod_employee", SqlFormatterNumber.numberToString(workingTime.codEmployee));
		builder.appendClauseWithAnd("weekday", SqlFormatterNumber.numberToString(workingTime.weekday));
		builder.appendClauseWithAnd("record_mode", RecordMode.RECORD_OK);
	}	

	
	
	public String generateClause() {
		return builder.generateClause();
	}

	
	
	public boolean checkClauseGeneration() {
		return builder.checkClauseGeneration();
	}
}
