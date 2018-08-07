package br.com.gda.business.material.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoDictionary;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinColumn;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class MatSelectSingle implements DaoStmt<MatInfo> {
	private final String LT_MAT = DaoDbTable.MAT_TABLE;	
	private final String RT_MAT_TEXT = DaoDbTable.MAT_TEXT_TABLE;
	private final String RT_MAT_TYPE_TEXT = DaoDbTable.MAT_TYPE_TEXT_TABLE;
	private final String RT_MAT_CATEGORY_TEXT = DaoDbTable.MAT_CATEG_TEXT_TABLE;
	private final String RT_MAT_GROUP_TEXT = DaoDbTable.MAT_GROUP_TEXT_TABLE;
	private final String RT_MAT_GROUP = DaoDbTable.MAT_GROUP_TABLE;
	private final String RT_CURRENCY_TEXT = DaoDbTable.CURRENCY_TEXT_TABLE;
	private final String RT_UNIT_TEXT = DaoDbTable.UNIT_TEXT_TABLE;
	private final String RT_BUSINESS_TEXT = DaoDbTable.BUSINESS_AREA_TEXT_TABLE;
	
	private DaoStmt<MatInfo> stmtSql;
	private DaoStmtOption<MatInfo> stmtOption;
	
	
	
	public MatSelectSingle(Connection conn, MatInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAT;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAT);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinMatText());		
		joins.add(buildJoinTypeText());
		joins.add(buildJoinCategoryText());
		joins.add(buildJoinCurrencyText());
		joins.add(buildJoinUnitText());
		joins.add(buildJoinGroupText());		
		joins.add(buildJoinBusinessCod());
		joins.add(buildJoinBusinessText());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinMatText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_material";
		oneColumn.rightColumnName = "Cod_material";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_MAT_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(join.rightTableName);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinTypeText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_type";
		oneColumn.rightColumnName = "Cod_type";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_MAT_TYPE_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(join.rightTableName);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinCategoryText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_category";
		oneColumn.rightColumnName = "Cod_category";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_MAT_CATEGORY_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(join.rightTableName);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinCurrencyText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_curr";
		oneColumn.rightColumnName = "Cod_curr";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_CURRENCY_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(join.rightTableName);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinUnitText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Unit";
		oneColumn.rightColumnName = "Unit";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		String rightTableName = RT_UNIT_TEXT;
		join.rightTableName = rightTableName;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(rightTableName);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinGroupText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_group";
		oneColumn.rightColumnName = "Cod_group";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		String rightTableName = RT_MAT_GROUP_TEXT;
		join.rightTableName = rightTableName;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(rightTableName);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinBusinessCod() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_group";
		oneColumn.rightColumnName = "Cod_group";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		String rightTableName = RT_MAT_GROUP;
		join.rightTableName = rightTableName;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	} 
	
	
	
	private DaoJoin buildJoinBusinessText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_MAT_GROUP;
		oneColumn.leftColumnName = "Cod_business";
		oneColumn.rightColumnName = "Cod_business";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		String rightTableName = RT_BUSINESS_TEXT;
		join.rightTableName = rightTableName;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(rightTableName);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.EQUAL);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(DaoDictionary.QUOTE);
		
		return constrainClause.toString();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<MatInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatInfo> getNewInstance() {
		return new MatSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String MAT_TEXT_COL = DaoDbTable.MAT_TEXT_TABLE + "." + "Name";
		private final String MAT_LANGU_COL = DaoDbTable.MAT_TEXT_TABLE + "." + "Language";
		private final String MAT_DESCR_COL = DaoDbTable.MAT_TEXT_TABLE + "." + "Description";
		private final String MAT_TYPE_TEXT_COL = DaoDbTable.MAT_TYPE_TEXT_TABLE + "." + "Name";
		private final String MAT_CATEGORY_TEXT_COL = DaoDbTable.MAT_CATEG_TEXT_TABLE + "." + "Name";
		private final String MAT_GROUP_TEXT_COL = DaoDbTable.MAT_GROUP_TEXT_TABLE + "." + "Name";
		private final String MAT_BUSINESS_COL = DaoDbTable.MAT_GROUP_TABLE + "." + "Cod_business";
		private final String MAT_BUSINESS_TEXT_COL = DaoDbTable.BUSINESS_AREA_TEXT_TABLE + "." + "Name";
		private final String CURRENCY_TEXT_COL = DaoDbTable.CURRENCY_TEXT_TABLE + "." + "Name";
		private final String UNIT_TEXT_COL = DaoDbTable.UNIT_TEXT_TABLE + "." + "Name";
		
		@Override public List<MatInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				MatInfo dataInfo = new MatInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codMat = stmtResult.getLong("Cod_material");
				dataInfo.txtMat = stmtResult.getString(MAT_TEXT_COL);
				dataInfo.description = stmtResult.getString(MAT_DESCR_COL);
				dataInfo.codType = stmtResult.getInt("Cod_type");
				dataInfo.txtType = stmtResult.getString(MAT_TYPE_TEXT_COL);
				dataInfo.codCategory = stmtResult.getInt("Cod_category");
				dataInfo.txtCategory = stmtResult.getString(MAT_CATEGORY_TEXT_COL);
				dataInfo.price = stmtResult.getDouble("Price");
				dataInfo.priceUnit = stmtResult.getInt("Price_unit");				
				dataInfo.codCurr = stmtResult.getString("Cod_curr");	
				dataInfo.txtCurr = stmtResult.getString(CURRENCY_TEXT_COL);
				dataInfo.codUnit = stmtResult.getString("Unit");	
				dataInfo.txtUnit = stmtResult.getString(UNIT_TEXT_COL);
				dataInfo.codGroup = stmtResult.getInt("Cod_group");	
				dataInfo.txtGroup = stmtResult.getString(MAT_GROUP_TEXT_COL);
				dataInfo.codBusiness = stmtResult.getInt(MAT_BUSINESS_COL);	
				dataInfo.txtBusiness = stmtResult.getString(MAT_BUSINESS_TEXT_COL);
				dataInfo.codLanguage = stmtResult.getString(MAT_LANGU_COL);	
				dataInfo.isLocked = stmtResult.getBoolean("Is_locked");	
				dataInfo.recordMode = stmtResult.getString("record_mode");					
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
