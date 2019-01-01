package br.com.gda.payService.payCustomer.model;

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
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.model.decisionTree.RootPayCusSelect;

public final class PayCusModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PayCusModelSelect(PayCusInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PayCusInfo recordInfo) {
		ModelOption<PayCusInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PayCusInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PayCusInfo> {		
		@Override public DeciTree<PayCusInfo> getInstance(DeciTreeOption<PayCusInfo> option) {
			return new RootPayCusSelect(option);
		}		
	}
}
