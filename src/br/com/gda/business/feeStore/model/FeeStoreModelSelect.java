package br.com.gda.business.feeStore.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeeStoreSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FeeStoreModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public FeeStoreModelSelect(FeeStoreInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(FeeStoreInfo recordInfo) {
		ModelOption<FeeStoreInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = FeeStoreInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<FeeStoreInfo> {		
		@Override public DeciTree<FeeStoreInfo> getInstance(DeciTreeOption<FeeStoreInfo> option) {
			return new RootFeeStoreSelect(option);
		}			
	}
}
