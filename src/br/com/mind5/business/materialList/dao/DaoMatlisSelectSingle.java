package br.com.mind5.business.materialList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoMatlisSelectSingle extends DaoStmtTemplate<MatlisInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TABLE;	
	
	
	public DaoMatlisSelectSingle(Connection conn, MatlisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_LIST_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatlisInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoMatlisWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<MatlisInfo> getResultParserHook() {
		return new DaoResultParser<MatlisInfo>() {
			@Override public List<MatlisInfo> parseResult(MatlisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatlisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatlisInfo dataInfo = new MatlisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoMatlisDbTableColumn.COL_COD_OWNER);
					dataInfo.codMat = stmtResult.getLong(DaoMatlisDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codType = stmtResult.getInt(DaoMatlisDbTableColumn.COL_COD_TYPE);
					dataInfo.codMatCateg = stmtResult.getInt(DaoMatlisDbTableColumn.COL_COD_CATEGORY);
					dataInfo.priceUnit = stmtResult.getInt(DaoMatlisDbTableColumn.COL_PRICE_UNIT);	
					dataInfo.codUnit = stmtResult.getString(DaoMatlisDbTableColumn.COL_COD_UNIT);	
					dataInfo.codGroup = stmtResult.getInt(DaoMatlisDbTableColumn.COL_COD_GROUP);
					dataInfo.codSubgroup = stmtResult.getInt(DaoMatlisDbTableColumn.COL_COD_MAT_SUBGROUP);					
					dataInfo.isLocked = stmtResult.getBoolean(DaoMatlisDbTableColumn.COL_IS_LOCKED);	
					dataInfo.recordMode = stmtResult.getString(DaoMatlisDbTableColumn.COL_RECORD_MODE);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoMatlisDbTableColumn.COL_COD_SNAPSHOT);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
