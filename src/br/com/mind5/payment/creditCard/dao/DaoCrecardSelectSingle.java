package br.com.mind5.payment.creditCard.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class DaoCrecardSelectSingle extends DaoStmtTemplate<CrecardInfo> {
	private final String MAIN_TABLE = DaoDbTable.CREDIT_CARD_TABLE;	
	
	
	public DaoCrecardSelectSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CrecardInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoCrecardWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CrecardInfo> getResultParserHook() {
		return new DaoResultParser<CrecardInfo>() {
			@Override public List<CrecardInfo> parseResult(CrecardInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CrecardInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CrecardInfo dataInfo = new CrecardInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoCrecardDbTableColumn.COL_COD_OWNER);
					dataInfo.codCreditCard = stmtResult.getLong(DaoCrecardDbTableColumn.COL_COD_CREDIT_CARD);
					dataInfo.codPayCustomer = stmtResult.getLong(DaoCrecardDbTableColumn.COL_COD_PAY_CUSTOMER);
					dataInfo.creditCardId = stmtResult.getString(DaoCrecardDbTableColumn.COL_CREDIT_CARD_ID);	
					dataInfo.creditCardBrand = stmtResult.getString(DaoCrecardDbTableColumn.COL_CREDIT_CARD_BRAND);	
					dataInfo.creditCardLast4 = stmtResult.getString(DaoCrecardDbTableColumn.COL_CREDIT_CARD_LAST4);
					dataInfo.recordMode = stmtResult.getString(DaoCrecardDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoCrecardDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoCrecardDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codAddressHolder = DaoFormatter.sqlToLong(stmtResult, DaoCrecardDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codAddressSnapshotHolder = DaoFormatter.sqlToLong(stmtResult, DaoCrecardDbTableColumn.COL_COD_ADDRESS_SNAPSHOT);
					dataInfo.codPhoneHolder = DaoFormatter.sqlToLong(stmtResult, DaoCrecardDbTableColumn.COL_COD_PHONE);
					dataInfo.codPhoneSnapshotHolder = DaoFormatter.sqlToLong(stmtResult, DaoCrecardDbTableColumn.COL_COD_PHONE_SNAPSHOT);	
					dataInfo.expirationMonth = stmtResult.getString(DaoCrecardDbTableColumn.COL_EXPIRATION_MONTH);
					dataInfo.expirationYear = stmtResult.getString(DaoCrecardDbTableColumn.COL_EXPIRATION_YEAR);
					dataInfo.nameHolder = stmtResult.getString(DaoCrecardDbTableColumn.COL_NAME_HOLDER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
