package br.com.mind5.business.addressSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoAddresnapInsertSingle extends DaoStmtTemplate<AddresnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_SNAPSHOT_TABLE;	
	
	
	public DaoAddresnapInsertSingle(Connection conn, AddresnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<AddresnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<AddresnapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, AddresnapInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddress);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);			
				stmt.setString(i++, recordInfo.codCountry);
				stmt.setString(i++, recordInfo.codState);
				stmt.setString(i++, recordInfo.city);
				stmt.setString(i++, recordInfo.district);
				stmt.setString(i++, recordInfo.street);
				stmt.setString(i++, recordInfo.streetNumber);
				stmt.setString(i++, recordInfo.complement);
				stmt.setString(i++, recordInfo.postalCode);
				stmt = DaoFormatter.geoToStmt(stmt, i++, recordInfo.latitude);	
				stmt = DaoFormatter.geoToStmt(stmt, i++, recordInfo.longitude);	
				stmt.setString(i++, recordInfo.line1);
				stmt.setString(i++, recordInfo.line2);
				stmt.setString(i++, recordInfo.line3);
				stmt.setString(i++, recordInfo.line4);
				stmt.setString(i++, recordInfo.line5);
				stmt.setString(i++, recordInfo.line6);
				stmt.setString(i++, recordInfo.line7);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRefSnapshot);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
				stmt.setString(i++, recordInfo.geoHash01);
				stmt.setString(i++, recordInfo.geoHash02);
				stmt.setString(i++, recordInfo.geoHash03);
				stmt.setString(i++, recordInfo.geoHash04);
				stmt.setString(i++, recordInfo.geoHash05);
				stmt.setString(i++, recordInfo.geoHash12);
				stmt.setString(i++, recordInfo.districtSearch);
	
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<AddresnapInfo> getResultParserHook() {
		return new DaoResultParser<AddresnapInfo>() {		
			@Override public List<AddresnapInfo> parseResult(AddresnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AddresnapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
