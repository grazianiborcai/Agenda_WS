package br.com.gda.employee.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.decisionTree.EmpWtimeRootSelect;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelperV2;
import br.com.gda.model.ModelOptionV2;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class EmpWtimeModelSelect implements Model {
	private ModelHelperV2<EmpWTimeInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmpWtimeModelSelect(EmpWTimeInfo workingTimeInfo) {
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
			return new EmpWtimeRootSelect(option);
		}		
	
	}
}
