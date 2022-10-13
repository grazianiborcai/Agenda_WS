package br.com.mind5.business.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class AddressDaoInsertSingle extends DaoStmtTemplate<AddressInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;
	
	
	public AddressDaoInsertSingle(Connection conn, AddressInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<AddressInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<AddressInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, AddressInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
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
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setString(i++, recordInfo.geoHash01);
				stmt.setString(i++, recordInfo.geoHash02);
				stmt.setString(i++, recordInfo.geoHash03);
				stmt.setString(i++, recordInfo.geoHash04);
				stmt.setString(i++, recordInfo.geoHash05);
				stmt.setString(i++, recordInfo.geoHash12);
				stmt.setString(i++, recordInfo.districtSearch);
				stmt.setString(i++, recordInfo.addressName);
				stmt.setBoolean(i++, recordInfo.isDefault);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codLegalPerson);	
	
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<AddressInfo> getResultParserHook() {
		return new DaoResultParser<AddressInfo>() {		
			@Override public List<AddressInfo> parseResult(AddressInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AddressInfo> finalResult = new ArrayList<>();
				recordInfo.codAddress = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
