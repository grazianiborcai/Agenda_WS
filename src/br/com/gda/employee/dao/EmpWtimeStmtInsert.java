package br.com.gda.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlFormatterNumber;



final class EmpWtimeStmtInsert extends EmpWtimeStmtAbstract {
	
	public EmpWtimeStmtInsert(SqlStmtOption<EmpWTimeInfo> option) {
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
		this.stmt.setLong(i++, this.option.recordInfo.codOwner);
		this.stmt.setLong(i++, this.option.recordInfo.codStore);
		this.stmt.setLong(i++, this.option.recordInfo.codEmployee);
		this.stmt.setInt(i++, this.option.recordInfo.weekday);
		this.stmt.setTime(i++, beginTime);
		this.stmt.setTime(i++, endTime);
		this.stmt.setString(i++, this.option.recordInfo.recordMode);
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.stmt.executeUpdate();
		return null;
	}
}
