package br.com.gda.business.material.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlDictionary;
import br.com.gda.sql.SqlJoin;
import br.com.gda.sql.SqlJoinColumn;
import br.com.gda.sql.SqlJoinType;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatSelectSingle implements SqlStmt<MatInfo> {
	private final String LT_MAT = SqlDbTable.MATERIAL_TABLE;	
	private final String RT_MAT_TEXT = SqlDbTable.MATERIAL_TEXT_TABLE;
	private final String RT_MAT_TYPE_TEXT = SqlDbTable.MATERIAL_TYPE_TEXT_TABLE;
	private final String RT_MAT_CATEGORY_TEXT = SqlDbTable.MATERIAL_CATEGORY_TEXT_TABLE;
	private final String RT_MAT_GROUP_TEXT = SqlDbTable.MATERIAL_GROUP_TEXT_TABLE;
	private final String RT_MAT_GROUP = SqlDbTable.MATERIAL_GROUP_TABLE;
	private final String RT_CURRENCY_TEXT = SqlDbTable.CURRENCY_TEXT_TABLE;
	private final String RT_UNIT_TEXT = SqlDbTable.UNIT_TEXT_TABLE;
	private final String RT_BUSINESS_TEXT = SqlDbTable.BUSINESS_AREA_TEXT_TABLE;
	
	private SqlStmt<MatInfo> stmtSql;
	private SqlStmtOption<MatInfo> stmtOption;
	
	
	
	public MatSelectSingle(Connection conn, MatInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAT;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(LT_MAT);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new MatWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();		
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
	
	
	
	private SqlJoin buildJoinMatText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_material";
		oneColumn.rightColumnName = "Cod_material";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_MAT_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_MAT_TEXT);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinTypeText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_type";
		oneColumn.rightColumnName = "Cod_type";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_MAT_TYPE_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_MAT_TYPE_TEXT);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinCategoryText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_category";
		oneColumn.rightColumnName = "Cod_category";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_MAT_CATEGORY_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_MAT_CATEGORY_TEXT);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinCurrencyText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_curr";
		oneColumn.rightColumnName = "Cod_curr";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_CURRENCY_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_CURRENCY_TEXT);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinUnitText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Unit";
		oneColumn.rightColumnName = "Unit";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		String rightTableName = RT_UNIT_TEXT;
		join.rightTableName = rightTableName;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(rightTableName);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinGroupText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_group";
		oneColumn.rightColumnName = "Cod_group";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		String rightTableName = RT_MAT_GROUP_TEXT;
		join.rightTableName = rightTableName;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(rightTableName);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinBusinessCod() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = "Cod_group";
		oneColumn.rightColumnName = "Cod_group";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		String rightTableName = RT_MAT_GROUP;
		join.rightTableName = rightTableName;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	} 
	
	
	
	private SqlJoin buildJoinBusinessText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = RT_MAT_GROUP;
		oneColumn.leftColumnName = "Cod_business";
		oneColumn.rightColumnName = "Cod_business";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		String rightTableName = RT_BUSINESS_TEXT;
		join.rightTableName = rightTableName;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(rightTableName);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(SqlDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.EQUAL);
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(SqlDictionary.QUOTE);
		
		return constrainClause.toString();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.SELECT, this.stmtOption);
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
	
	
	
	@Override public SqlStmt<MatInfo> getNewInstance() {
		return new MatSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<MatInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String MAT_TEXT_COL = SqlDbTable.MATERIAL_TEXT_TABLE + "." + "Name";
		private final String MAT_LANGU_COL = SqlDbTable.MATERIAL_TEXT_TABLE + "." + "Language";
		private final String MAT_DESCR_COL = SqlDbTable.MATERIAL_TEXT_TABLE + "." + "Description";
		private final String MAT_TYPE_TEXT_COL = SqlDbTable.MATERIAL_TYPE_TEXT_TABLE + "." + "Name";
		private final String MAT_CATEGORY_TEXT_COL = SqlDbTable.MATERIAL_CATEGORY_TEXT_TABLE + "." + "Name";
		private final String MAT_GROUP_TEXT_COL = SqlDbTable.MATERIAL_GROUP_TEXT_TABLE + "." + "Name";
		private final String MAT_BUSINESS_COL = SqlDbTable.MATERIAL_GROUP_TABLE + "." + "Cod_business";
		private final String MAT_BUSINESS_TEXT_COL = SqlDbTable.BUSINESS_AREA_TEXT_TABLE + "." + "Name";
		private final String CURRENCY_TEXT_COL = SqlDbTable.CURRENCY_TEXT_TABLE + "." + "Name";
		private final String UNIT_TEXT_COL = SqlDbTable.UNIT_TEXT_TABLE + "." + "Name";
		
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
