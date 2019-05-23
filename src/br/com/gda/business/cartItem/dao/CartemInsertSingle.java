package br.com.gda.business.cartItem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public class CartemInsertSingle implements DaoStmt<CartemInfo> {
	private DaoStmt<CartemInfo> stmtSql;
	private DaoStmtOption<CartemInfo> stmtOption;
	
	
	
	public CartemInsertSingle(Connection conn, CartemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CartemInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.CART_ITM_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = null;
		stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, stmtOption);
	}
		
	
	
	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<CartemInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CartemInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CartemInfo recordInfo) throws SQLException {
			
			Time beginTime = null;
			if (recordInfo.beginTime != null)		
				beginTime = Time.valueOf(recordInfo.beginTime);
			
			
			Time endTime = null;
			if (recordInfo.endTime != null)		
				endTime = Time.valueOf(recordInfo.endTime);
			
			
			Date date = null;
			if (recordInfo.date != null)		
				date = Date.valueOf(recordInfo.date);
			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codUser);
			stmt.setInt(i++, recordInfo.itemNumber);	
			stmt.setInt(i++, recordInfo.quantity);
			
			
			if (recordInfo.codStore >= 0) {
				stmt.setLong(i++, recordInfo.codStore);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codMat >= 0) {
				stmt.setLong(i++, recordInfo.codMat);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
						
			
			stmt.setTime(i++, beginTime);
			stmt.setTime(i++, endTime);
			stmt.setDate(i++, date);
			
			
			if (recordInfo.codEmployee >= 0) {
				stmt.setLong(i++, recordInfo.codEmployee);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codItemCateg == DefaultValue.character()) {
				stmt.setNull(i++, Types.VARCHAR);
			} else {
				stmt.setString(i++, Character.toString(recordInfo.codItemCateg)); 
			}	
			

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<CartemInfo> getNewInstance() {
		return new CartemInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
