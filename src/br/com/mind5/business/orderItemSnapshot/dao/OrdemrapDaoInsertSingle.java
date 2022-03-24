package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public class OrdemrapDaoInsertSingle extends DaoStmtTemplate<OrdemrapInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_SNAPSHOT_TABLE;		
	
	
	public OrdemrapDaoInsertSingle(Connection conn, OrdemrapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OrdemrapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OrdemrapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OrdemrapInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrderItem);
				stmt.setLong(i++, recordInfo.codOrder);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
				stmt.setInt(i++, recordInfo.quantity);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMatSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.price);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totitem);
				stmt.setString(i++, recordInfo.codCurr);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt.setString(i++, recordInfo.codOrderStatus);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayOrder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayOrderItem);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codRefundPolicyGroup);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
				
				return stmt;
			}		
		};
	}
	
	
		
	@Override protected DaoResultParser<OrdemrapInfo> getResultParserHook() {
		return new DaoResultParser<OrdemrapInfo>() {		
			@Override public List<OrdemrapInfo> parseResult(OrdemrapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrdemrapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}	
}
