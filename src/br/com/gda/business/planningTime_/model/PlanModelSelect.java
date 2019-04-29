package br.com.gda.business.planningTime_.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.business.planningTime_.model.decisionTree.RootPlanSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PlanModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PlanModelSelect(PlanInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PlanInfo recordInfo) {
		ModelOption<PlanInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PlanInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper.factory(helperOption, recordInfo);	
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PlanInfo> {		
		@Override public DeciTree<PlanInfo> getInstance(DeciTreeOption<PlanInfo> option) {
			return new RootPlanSelect(option);
		}			
	}
}
