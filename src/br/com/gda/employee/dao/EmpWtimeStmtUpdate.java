package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import br.com.gda.sql.SqlFormatterNumber;

final class EmpWtimeStmtUpdate extends EmpWtimeStmtAbstract {
	
	public EmpWtimeStmtUpdate(EmpStmtOption option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWtimeBuilderUpdate builder = new EmpWtimeBuilderUpdate(option.schemaName, option.workingTime);
		return builder.generateStatement();
	}
	
	
	
	@Override protected void translateParameterIntoValueHook() throws SQLException {
		Time beginTime = SqlFormatterNumber.localToSqlTime(this.option.workingTime.beginTime);
		Time endTime = SqlFormatterNumber.localToSqlTime(this.option.workingTime.endTime);				
		
		int i = 1;
		this.statement.setTime(i++, beginTime);
		this.statement.setTime(i++, endTime);
		this.statement.setString(i++, this.option.workingTime.recordMode);
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.statement.executeUpdate();
		return null;
	}
}
