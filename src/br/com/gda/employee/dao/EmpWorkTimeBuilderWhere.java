package br.com.gda.employee.dao;

import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlWhereBuilder;

final class EmpWorkTimeBuilderWhere {
	private SqlWhereBuilder builder;
	
	
	public EmpWorkTimeBuilderWhere(EmpWorkTimeInfo workingTime) {
		this(workingTime, true);
	}
	
	
	
	public EmpWorkTimeBuilderWhere(EmpWorkTimeInfo workingTime, boolean ignoreNullCondition) {
		checkArgument(workingTime);		
		builder = SqlWhereBuilder.factory(ignoreNullCondition);
		buildClause(workingTime);
	}
	
	
	
	private void checkArgument(EmpWorkTimeInfo workingTime) {
		if (workingTime == null)
			throw new NullPointerException();
	}
	
	
	
	private void buildClause(EmpWorkTimeInfo workingTime) {
		builder.appendClauseWithAnd("cod_owner", SqlFormatterNumber.numberToString(workingTime.codOwner));
		builder.appendClauseWithAnd("cod_store", SqlFormatterNumber.numberToString(workingTime.codStore));
		builder.appendClauseWithAnd("cod_employee", SqlFormatterNumber.numberToString(workingTime.codEmployee));
		builder.appendClauseWithAnd("record_mode", RecordMode.RECORD_OK);
	}	

	
	
	public String generateClause() {
		return builder.generateClause();
	}

	
	
	public boolean checkClauseGeneration() {
		return builder.checkClauseGeneration();
	}
}
