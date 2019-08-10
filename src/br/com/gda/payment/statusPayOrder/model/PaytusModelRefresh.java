package br.com.gda.payment.statusPayOrder.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.model.decisionTree.RootPaytusRefresh;

public final class PaytusModelRefresh implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PaytusModelRefresh(PaytusInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PaytusInfo recordInfo) {
		ModelOption_<PaytusInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = PaytusInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper_.factory(helperOption, recordInfo);
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PaytusInfo> {		
		@Override public DeciTree<PaytusInfo> getInstance(DeciTreeOption<PaytusInfo> option) {
			return new RootPaytusRefresh(option);
		}			
	}
}
