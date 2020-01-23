package br.com.mind5.business.scheduleLineSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public class SchedinapInsertSingle extends DaoStmtTemplate<SchedinapInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_SNAPSHOT_TABLE;
	
	
	public SchedinapInsertSingle(Connection conn, SchedinapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<SchedinapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SchedinapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SchedinapInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codSchedule);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMatSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.day);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.quarter);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codWeekday);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt.setString(i++, recordInfo.codScheduleStatus);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrderItem);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParserV2<SchedinapInfo> getResultParserHook() {
		return new DaoResultParserV2<SchedinapInfo>() {		
			@Override public List<SchedinapInfo> parseResult(SchedinapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SchedinapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
