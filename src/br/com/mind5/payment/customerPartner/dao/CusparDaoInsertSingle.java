package br.com.mind5.payment.customerPartner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparDaoInsertSingle extends DaoStmtTemplate<CusparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_CUS_TABLE;
	
	
	public CusparDaoInsertSingle(Connection conn, CusparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CusparInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CusparInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CusparInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayPartner);
				stmt.setString(i++, recordInfo.compoundId);
				stmt.setString(i++, recordInfo.customerId);
				stmt.setNull(i++, Types.VARCHAR);
				stmt.setNull(i++, Types.VARCHAR);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddress);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhone);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneSnapshot);
	
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<CusparInfo> getResultParserHook() {
		return new DaoResultParser<CusparInfo>() {	
			@Override public List<CusparInfo> parseResult(CusparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CusparInfo> finalResult = new ArrayList<>();
				recordInfo.codPayCustomer = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
