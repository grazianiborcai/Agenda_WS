package br.com.gda.payService.payPartnerStore.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;
import br.com.gda.payService.payPartnerStore.model.decisionTree.RootPayparStoreSelect;

public final class PayparStoreModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PayparStoreModelSelect(PayparStoreInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PayparStoreInfo recordInfo) {
		ModelOption<PayparStoreInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PayparStoreInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PayparStoreInfo> {		
		@Override public DeciTree<PayparStoreInfo> getInstance(DeciTreeOption<PayparStoreInfo> option) {
			return new RootPayparStoreSelect(option);
		}			
	}
}
