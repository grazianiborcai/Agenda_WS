package br.com.gda.payment.refundOrder.model;

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
import br.com.gda.payment.refundOrder.info.RefuInfo;
import br.com.gda.payment.refundOrder.model.decisionTree.RootRefuRefund;


public final class RefuModelRefund implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public RefuModelRefund(RefuInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(RefuInfo recordInfo) {
		ModelOption<RefuInfo> helperOption = new ModelOption<>();
		
		helperOption.recordClass = RefuInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<RefuInfo> {		
		@Override public DeciTree<RefuInfo> getInstance(DeciTreeOption<RefuInfo> option) {
			return new RootRefuRefund(option);
		}			
	}
}
