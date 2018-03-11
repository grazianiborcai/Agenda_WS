package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlFormatterNumber;



final class EmpWorkTimeStmtInsert extends EmpWorkTimeStmtAbstract {
	
	public EmpWorkTimeStmtInsert(EmpStmtOption option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWorkTimeBuilderInsert builder = new EmpWorkTimeBuilderInsert(option.schemaName, option.workingTime);
		return builder.generateStatement();
	}
	
	
	
	@Override protected void translateParameterIntoValueHook() throws SQLException {
		Time beginTime = SqlFormatterNumber.localToSqlTime(this.option.workingTime.beginTime);
		Time endTime = SqlFormatterNumber.localToSqlTime(this.option.workingTime.endTime);				
		
		int i = 1;
		this.statement.setLong(i++, this.option.workingTime.codOwner);
		this.statement.setLong(i++, this.option.workingTime.codStore);
		this.statement.setLong(i++, this.option.workingTime.codEmployee);
		this.statement.setInt(i++, this.option.workingTime.weekday);
		this.statement.setTime(i++, beginTime);
		this.statement.setTime(i++, endTime);
		this.statement.setString(i++, RecordMode.RECORD_OK); //TODO: mover para a classe model
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.statement.executeUpdate();
		return null;
	}
}
