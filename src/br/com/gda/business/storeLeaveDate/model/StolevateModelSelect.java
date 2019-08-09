package br.com.gda.business.storeLeaveDate.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolevateSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolevateModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public StolevateModelSelect(StolevateInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(StolevateInfo recordInfo) {
		ModelOption<StolevateInfo> helperOption = new ModelOption<>();
		
		helperOption.recordClass = StolevateInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<StolevateInfo> {		
		@Override public DeciTree<StolevateInfo> getInstance(DeciTreeOption<StolevateInfo> option) {
			return new RootStolevateSelect(option);
		}			
	}
}
