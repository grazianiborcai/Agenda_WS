package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmployeeWorkingTimeInfo;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStatementBuilder;
import br.com.gda.sql.SqlStatementBuilderOption;

class EmployeeWorkingTimeBuilderInsert {	
	private SqlStatementBuilder builder;
	private EmployeeWorkingTimeInfo workingTime;
	private String schemaName;
	
	
	
	public EmployeeWorkingTimeBuilderInsert(String schemaName, EmployeeWorkingTimeInfo workingTime) {
		this.workingTime = workingTime;
		this.schemaName = schemaName;
		
		checkArgument();
		buildStatement();
	}
	
	
	
	private void checkArgument() {
		if (this.workingTime == null)
			throw new NullPointerException("workingTime aegument is null");
		
		if (this.schemaName == null)
			throw new NullPointerException("schemaName aegument is null");
	}
	
	
	
	private void buildStatement() {
		SqlStatementBuilderOption option = new SqlStatementBuilderOption();		
		
		option.schemaName = this.schemaName;
		option.tableName = EmpoyeeTableName.EMPLOYEE_WORKING_TIME_TABLE;	
		option.insertColumns = buildColumns();
		
		builder = SqlStatementBuilder.factory(SqlOperation.INSERT, option);
	}
	
	
	
	private List<String> buildColumns() {
		List<String> resultColumns = new ArrayList<>();
		
		resultColumns.add("cod_owner");
		resultColumns.add("cod_store");
		resultColumns.add("cod_employee");
		resultColumns.add("weekday");
		resultColumns.add("begin_time");
		resultColumns.add("end_time");
		resultColumns.add("record_mode");
		
		return resultColumns;
	}
	
	
	
	public boolean checkStatementGeneration() {
		return builder.checkStatementGeneration();
	}
	
	
	
	public String generateStatement() {
		String resultStatement = builder.generateStatement();
		return resultStatement;
	}
}
