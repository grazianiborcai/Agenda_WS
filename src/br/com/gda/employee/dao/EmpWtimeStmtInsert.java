package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import br.com.gda.sql.SqlFormatterNumber;



final class EmpWtimeStmtInsert extends EmpWtimeStmtAbstract {
	
	public EmpWtimeStmtInsert(EmpStmtOption option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWtimeBuilderInsert builder = new EmpWtimeBuilderInsert(option.schemaName, option.recordInfo);
		return builder.generateStatement();
	}
	
	
	
	@Override protected void translateParameterIntoValueHook() throws SQLException {
		Time beginTime = SqlFormatterNumber.localToSqlTime(this.option.recordInfo.beginTime);
		Time endTime = SqlFormatterNumber.localToSqlTime(this.option.recordInfo.endTime);				
		
		int i = 1;
		this.statement.setLong(i++, this.option.recordInfo.codOwner);
		this.statement.setLong(i++, this.option.recordInfo.codStore);
		this.statement.setLong(i++, this.option.recordInfo.codEmployee);
		this.statement.setInt(i++, this.option.recordInfo.weekday);
		this.statement.setTime(i++, beginTime);
		this.statement.setTime(i++, endTime);
		this.statement.setString(i++, this.option.recordInfo.recordMode);
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.statement.executeUpdate();
		return null;
	}
}
