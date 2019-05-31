package br.com.gda.business.feeDefault.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.business.feeDefault.model.decisionTree.RootFeedefSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FeedefModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public FeedefModelSelect(FeedefInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(FeedefInfo recordInfo) {
		ModelOption<FeedefInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = FeedefInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<FeedefInfo> {		
		@Override public DeciTree<FeedefInfo> getInstance(DeciTreeOption<FeedefInfo> option) {
			return new RootFeedefSelect(option);
		}			
	}
}
