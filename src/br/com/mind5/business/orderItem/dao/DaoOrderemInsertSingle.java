package br.com.mind5.business.orderItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public class DaoOrderemInsertSingle extends DaoStmtTemplate<OrderemInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_TABLE;		
	
	
	public DaoOrderemInsertSingle(Connection conn, OrderemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OrderemInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OrderemInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OrderemInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codOrder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrderItem);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
				stmt.setInt(i++, recordInfo.quantity);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.price);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totitem);
				stmt.setString(i++, recordInfo.codCurr);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				
				return stmt;
			}		
		};
	}
}
