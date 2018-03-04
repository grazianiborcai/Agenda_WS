package br.com.gda.employee.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStatement;



public final class EmployeeWorkingTimeStmtInsert implements SqlStatement {
	private final EmployeeStmtOption option;
	private String statementSkeleton;
	private PreparedStatement statement;
	
	public EmployeeWorkingTimeStmtInsert(EmployeeStmtOption option) {
		try {
			this.option = (EmployeeStmtOption) option.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	public void generateStmt() throws SQLException {
		buildStatementSkeleton();
		createStatement();
		translateParameterIntoValue();
	}
	
	
	
	private void buildStatementSkeleton() {
		EmployeeWorkingTimeBuilderInsert builder = new EmployeeWorkingTimeBuilderInsert(option.schemaName, option.workingTime);
		this.statementSkeleton = builder.generateStatement();
	}
	
	
	
	private void createStatement() throws SQLException {
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
	
	
	
	public boolean checkStatementGeneration() {
		return tryToCheckStatementGeneration();
	}
	
	
	
	private boolean tryToCheckStatementGeneration() {
		try {
			checkArguments();
			checkConnection();
			return checkStatementSkeleton();
			
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
	
	
	
	private boolean checkStatementSkeleton() throws Exception {
		buildStatementSkeleton();
		return (this.statementSkeleton != null);
	}
	
	
	
	private void checkConnection() throws SQLException {
		PreparedStatement tester = this.option.conn.prepareStatement("SELECT 1;");
		tester.executeQuery();
	}
	
	
	
	public void executeStatement() throws SQLException {
		this.statement.executeUpdate();
	}
	
	
	
	@Override public String toString() {
		return this.statement.toString();
	}
}
