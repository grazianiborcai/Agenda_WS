package br.com.gda.employee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmt;

abstract class EmpWtimeStmtAbstract implements SqlStmt<EmpWTimeInfo> {
	protected EmpStmtOption<EmpWTimeInfo> option;
	protected String statementSkeleton;
	protected PreparedStatement statement;
	protected List<EmpWTimeInfo> resultset = new ArrayList<>();
	protected ResultSet stmtResult;
	
	
	public EmpWtimeStmtAbstract(EmpStmtOption<EmpWTimeInfo> option) {
		makeDefensiveCopy(option);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void makeDefensiveCopy(EmpStmtOption<EmpWTimeInfo> option) {
		try {
			this.option = (EmpStmtOption<EmpWTimeInfo>) option.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	@Override public void generateStmt() throws SQLException {
		buildStmtSkeleton();	
		createStmt();
		translateParameterIntoValueHook();
	}
	
	
	
	private void buildStmtSkeleton() {
		this.statementSkeleton = buildStmtSkeletonHook();
	}
	
	
	
	protected String buildStmtSkeletonHook() {
		//Template method to be overridden by subclasses
		return null;
	}
	
	
	
	private void createStmt() throws SQLException {
		this.statement = this.option.conn.prepareStatement(this.statementSkeleton);
	}
	
	
	
	protected void translateParameterIntoValueHook() throws SQLException {
		//Template method to be overridden by subclasses
	}
	
	
	
	@Override public boolean checkStmtGeneration() {
		return tryToCheckStmtGeneration();
	}
	
	
	
	private boolean tryToCheckStmtGeneration() {
		try {
			checkArguments();
			checkConnection();
			checkStmtSkeleton();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	private void checkArguments() {
		if (this.option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		
		if (this.option.conn == null)
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private void checkConnection() throws SQLException {
		PreparedStatement tester = this.option.conn.prepareStatement("SELECT 1;");
		tester.executeQuery();
	}

	
	
	private void checkStmtSkeleton() throws Exception {
		if (this.statementSkeleton == null)
			buildStmtSkeleton();
		
		if (this.statementSkeleton == null)
			throw new IllegalStateException(SystemMessage.ERROR_CREATING_SKELETON_STATEMENT);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		this.stmtResult = executeStmtHook();
		buildResultset();
	}
	
	
	
	protected ResultSet executeStmtHook() throws SQLException {
		//Template method to be overridden by subclasses
		return null;
	}
	
	
	
	private void buildResultset() throws SQLException {
		if (this.stmtResult == null)
			return;
		
		
		while (this.stmtResult.next()) {
			if (this.stmtResult.getLong("cod_employee") <= 0)
				return;
			
			EmpWTimeInfo dataInfo = new EmpWTimeInfo();
			dataInfo.codOwner = this.stmtResult.getLong("cod_owner");
			dataInfo.codStore = this.stmtResult.getLong("cod_store");
			dataInfo.codEmployee = this.stmtResult.getLong("cod_employee");
			dataInfo.weekday = this.stmtResult.getInt("weekday");
			dataInfo.recordMode = this.stmtResult.getString("record_mode");
			
			Time tempTime = this.stmtResult.getTime("begin_time");
			if (tempTime != null)
				dataInfo.beginTime = tempTime.toLocalTime();
			
			tempTime = this.stmtResult.getTime("end_time");
			if (tempTime != null)
				dataInfo.endTime = tempTime.toLocalTime();
			
			
			this.resultset.add(dataInfo);
		}	
	}
	
	
	
	@Override public List<EmpWTimeInfo> getResultset() {		
		return this.resultset;
	}
	
	
	
	@Override public String toString() {
		return this.statement.toString();
	}
}
