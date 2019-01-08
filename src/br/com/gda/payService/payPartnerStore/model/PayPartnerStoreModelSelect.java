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
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreInfo;
import br.com.gda.payService.payPartnerStore.model.decisionTree.RootPayPartnerStoreSelect;

public final class PayPartnerStoreModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PayPartnerStoreModelSelect(PayPartnerStoreInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PayPartnerStoreInfo recordInfo) {
		ModelOption<PayPartnerStoreInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PayPartnerStoreInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PayPartnerStoreInfo> {		
		@Override public DeciTree<PayPartnerStoreInfo> getInstance(DeciTreeOption<PayPartnerStoreInfo> option) {
			return new RootPayPartnerStoreSelect(option);
		}			
	}
}
