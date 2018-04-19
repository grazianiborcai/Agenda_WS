package br.com.gda.employee.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.employee.dao.EmpWtimeStmtExecDelete;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.employee.model.checker.CheckerEmpWtimeMandatoryWrite;
import br.com.gda.employee.model.decisionTree.EmpWtimeRootDelete;
import br.com.gda.employee.model.decisionTree.EmpWtimeRootInsert;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelHelperV2;
import br.com.gda.model.ModelOption;
import br.com.gda.model.ModelOptionV2;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecFactory;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWtimeModelDelete implements Model {	
	private ModelHelperV2<EmpWTimeInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmpWtimeModelDelete(EmpWTimeInfo workingTimeInfo) {
		initialize();
		buildHelper(workingTimeInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(EmpWTimeInfo workingTimeInfo) {
		ModelOptionV2<EmpWTimeInfo> helperOption = new ModelOptionV2<>();
		
		helperOption.infoRecordClass = EmpWTimeInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = new ModelHelperV2<>(helperOption, workingTimeInfo);
	}


	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DecisionTreeFactory<EmpWTimeInfo> {		
		@Override public DecisionTree<EmpWTimeInfo> getDecisionTree(DecisionTreeOption<EmpWTimeInfo> option) {
			return new EmpWtimeRootDelete(option);
		}		
	
	}
	
	
	/*
	private ModelHelper<EmpWTimeInfo> helper;
	
	public EmpWtimeModelDelete(EmpWTimeInfo workingTimeInfo) {
		ModelOption<EmpWTimeInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = EmpWTimeInfo.class;
		helperOption.visitorChecker = buildModelChecker();
		helperOption.visitorStmtExec = buildStmtExec();
		
		helper = new ModelHelper<>(helperOption, workingTimeInfo);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildModelChecker() {
		List<ModelChecker<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checker = new CheckerEmpWtimeExistOnDb(EXIST_ON_DB);
		stack.add(checker);		
		
		 return new ModelCheckerStack<EmpWTimeInfo>(stack);
	}
	
	
	
	private SqlStmtExecFactory<EmpWTimeInfo> buildStmtExec() {
		return new EmpWtimeModelStmtExec();
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	private class EmpWtimeModelStmtExec implements SqlStmtExecFactory<EmpWTimeInfo> {		
		@Override public SqlStmtExec<EmpWTimeInfo> getStmtExec(List<SqlStmtExecOption<EmpWTimeInfo>> sqlStmtOptions) {
			return new EmpWtimeStmtExecDelete(sqlStmtOptions);
		}		
	}
	*/
}
