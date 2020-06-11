package br.com.mind5.masterData.fileDocType.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.fileDocType.info.FidoceInfo;

public final class DaoFidoceSelectSingle extends DaoStmtTemplate<FidoceInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_DOC_TYPE_TABLE;
	
	
	public DaoFidoceSelectSingle(Connection conn, FidoceInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FidoceInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoFidoceWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(FidoceInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoFidoceJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<FidoceInfo> getResultParserHook() {
		return new DaoResultParser<FidoceInfo>() {
			@Override public List<FidoceInfo> parseResult(FidoceInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FidoceInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FidoceInfo dataInfo = new FidoceInfo();
					
					dataInfo.codFileDocType = stmtResult.getString(DaoFidoceDbTableColumn.COL_COD_FILE_DOC_TYPE);
					dataInfo.txtFileDocType = stmtResult.getString(DaoFidoceDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoFidoceDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
