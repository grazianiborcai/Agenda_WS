package br.com.mind5.business.cartItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public class CartemInsertSingle extends DaoStmtTemplate<CartemInfo> {
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_TABLE;		
	
	
	public CartemInsertSingle(Connection conn, CartemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CartemInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CartemInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CartemInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
				stmt.setInt(i++, recordInfo.quantity);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);		
	
				return stmt;
			}		
		};
	}
}
