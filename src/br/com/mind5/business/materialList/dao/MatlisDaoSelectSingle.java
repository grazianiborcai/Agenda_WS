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

public final class MatlisDaoSelectSingle extends DaoStmtTemplate<MatlisInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TABLE;	
	
	
	public MatlisDaoSelectSingle(Connection conn, MatlisInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new MatlisDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = stmtResult.getLong(MatlisDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codMat = stmtResult.getLong(MatlisDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codStore = stmtResult.getLong(MatlisDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codType = stmtResult.getInt(MatlisDaoDbTableColumn.COL_COD_TYPE);
					dataInfo.codMatCateg = stmtResult.getInt(MatlisDaoDbTableColumn.COL_COD_CATEGORY);
					dataInfo.priceUnit = stmtResult.getInt(MatlisDaoDbTableColumn.COL_PRICE_UNIT);	
					dataInfo.codUnit = stmtResult.getString(MatlisDaoDbTableColumn.COL_COD_UNIT);	
					dataInfo.codGroup = stmtResult.getInt(MatlisDaoDbTableColumn.COL_COD_GROUP);
					dataInfo.codSubgroup = stmtResult.getInt(MatlisDaoDbTableColumn.COL_COD_MAT_SUBGROUP);					
					dataInfo.isLocked = stmtResult.getBoolean(MatlisDaoDbTableColumn.COL_IS_LOCKED);	
					dataInfo.recordMode = stmtResult.getString(MatlisDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, MatlisDaoDbTableColumn.COL_COD_SNAPSHOT);				
					
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
