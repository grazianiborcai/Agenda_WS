package br.com.gda.employee.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmt;



public final class EmpWorkTimeStmtInsert implements SqlStmt {
	private final EmpStmtOption option;
	private String statementSkeleton;
	private PreparedStatement statement;
	
	public EmpWorkTimeStmtInsert(EmpStmtOption option) {
		try {
			this.option = (EmpStmtOption) option.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	public void generateStmt() throws SQLException {
		buildStmtSkeleton();
		createStmt();
		translateParameterIntoValue();
	}
	
	
	
	private void buildStmtSkeleton() {
		EmpWorkTimeBuilderInsert builder = new EmpWorkTimeBuilderInsert(option.schemaName, option.workingTime);
		this.statementSkeleton = builder.generateStatement();
	}
	
	
	
	private void createStmt() throws SQLException {
		this.statement = this.option.conn.prepareStatement(this.statementSkeleton);
	}
	
	
	
	private void translateParameterIntoValue() throws SQLException {
		Time beginTime = SqlFormatterNumber.localToSqlTime(this.option.workingTime.beginTime);
		Time endTime = SqlFormatterNumber.localToSqlTime(this.option.workingTime.endTime);				
		
		int i = 1;
		this.statement.setLong(i++, this.option.workingTime.codOwner);
		this.statement.setLong(i++, this.option.workingTime.codStore);
		this.statement.setLong(i++, this.option.workingTime.codEmployee);
		this.statement.setInt(i++, this.option.workingTime.weekday);
		this.statement.setTime(i++, beginTime);
		this.statement.setTime(i++, endTime);
		this.statement.setString(i++, RecordMode.RECORD_OK);
	}
	
	
	
	public boolean checkStmtGeneration() {
		return tryToCheckStmtGeneration();
	}
	
	
	
	private boolean tryToCheckStmtGeneration() {
		try {
			checkArguments();
			checkConnection();
			return checkStmtSkeleton();
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	private void checkArguments() {
		if (this.option == null)
			throw new NullPointerException("option argument is null");
		
		if (this.option.conn == null)
			throw new NullPointerException("option.conn argument is null");
	}
	
	
	
	private boolean checkStmtSkeleton() throws Exception {
		buildStmtSkeleton();
		return (this.statementSkeleton != null);
	}
	
	
	
	private void checkConnection() throws SQLException {
		PreparedStatement tester = this.option.conn.prepareStatement("SELECT 1;");
		tester.executeQuery();
	}
	
	
	
	public void executeStmt() throws SQLException {
		this.statement.executeUpdate();
	}
	
	
	
	@Override public String toString() {
		return this.statement.toString();
	}
}
