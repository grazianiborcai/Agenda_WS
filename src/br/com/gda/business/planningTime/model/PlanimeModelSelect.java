package br.com.gda.business.planningTime.model;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.planningTime.model.decisionTree.RootPlanimeSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PlanimeModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PlanimeModelSelect(String incomingData, HttpServletRequest request) {
		initialize();
		buildHelper(incomingData, request);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(String incomingData, HttpServletRequest request) {
		ModelOption<PlanimeInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PlanimeInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper.factory(helperOption, incomingData, request);	
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PlanimeInfo> {		
		@Override public DeciTree<PlanimeInfo> getInstance(DeciTreeOption<PlanimeInfo> option) {
			return new RootPlanimeSelect(option);
		}			
	}
}
