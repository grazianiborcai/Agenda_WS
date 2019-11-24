package br.com.mind5.business.materialSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.dao.MatDbTableColumn;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class MatsnapSelectSingle implements DaoStmt<MatsnapInfo> {
	private final String LT_MAT_SNAP = DaoDbTable.MAT_SNAPSHOT_TABLE;
	
	private DaoStmt<MatsnapInfo> stmtSql;
	private DaoStmtOption_<MatsnapInfo> stmtOption;
	
	
	
	public MatsnapSelectSingle(Connection conn, MatsnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatsnapInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption_<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_MAT_SNAP;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAT_SNAP);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatsnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
	}
	
	

	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<MatsnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatsnapInfo> getNewInstance() {
		return new MatsnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<MatsnapInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatsnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatsnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				MatsnapInfo dataInfo = new MatsnapInfo();
				dataInfo.codOwner = stmtResult.getLong(MatsnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(MatsnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codMat = stmtResult.getLong(MatsnapDbTableColumn.COL_COD_MATERIAL);
				dataInfo.codType = stmtResult.getInt(MatsnapDbTableColumn.COL_COD_TYPE);
				dataInfo.codMatCateg = stmtResult.getInt(MatsnapDbTableColumn.COL_COD_CATEGORY);
				dataInfo.priceUnit = stmtResult.getInt(MatsnapDbTableColumn.COL_PRICE_UNIT);	
				dataInfo.codUnit = stmtResult.getString(MatsnapDbTableColumn.COL_COD_UNIT);	
				dataInfo.codGroup = stmtResult.getInt(MatsnapDbTableColumn.COL_COD_GROUP);
				dataInfo.isLocked = stmtResult.getBoolean(MatsnapDbTableColumn.COL_IS_LOCKED);	
				dataInfo.recordMode = stmtResult.getString(MatsnapDbTableColumn.COL_RECORD_MODE);
				
				stmtResult.getLong(MatDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(MatDbTableColumn.COL_LAST_CHANGED_BY);
				
				Timestamp lastChanged = stmtResult.getTimestamp(MatsnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
