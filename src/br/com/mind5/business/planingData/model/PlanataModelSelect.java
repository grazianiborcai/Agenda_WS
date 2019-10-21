package br.com.mind5.business.planingData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.decisionTree.RootPlanataSelect;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;

public final class PlanataModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PlanataModelSelect(PlanataInfo employeeInfo) {
		initialize();
		buildHelper(employeeInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PlanataInfo employeeInfo) {
		ModelOption_<PlanataInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = PlanataInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper_.factory(helperOption, employeeInfo);
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PlanataInfo> {		
		@Override public DeciTree<PlanataInfo> getInstance(DeciTreeOption<PlanataInfo> option) {
			return new RootPlanataSelect(option);
		}		
	}
}
