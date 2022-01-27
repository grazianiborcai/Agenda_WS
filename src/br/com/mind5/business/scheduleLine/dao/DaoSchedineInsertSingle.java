package br.com.mind5.business.scheduleLine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public class DaoSchedineInsertSingle extends DaoStmtTemplate<SchedineInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;
	
	
	public DaoSchedineInsertSingle(Connection conn, SchedineInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}

	
	
	@Override protected DaoStmtParamTranslator<SchedineInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SchedineInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SchedineInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrderItem);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.day);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.quarter);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codWeekday);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt.setString(i++, recordInfo.codScheduleStatus);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codScheduleRef);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPet);
				
				return stmt;
			}		
		};
	}
	
	
	
	
	@Override protected DaoResultParser<SchedineInfo> getResultParserHook() {
		return new DaoResultParser<SchedineInfo>() {		
			@Override public List<SchedineInfo> parseResult(SchedineInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SchedineInfo> finalResult = new ArrayList<>();
				recordInfo.codSchedule = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
