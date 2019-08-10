package br.com.gda.business.order.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.decisionTree.RootOrderCancel;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;

public final class OrderModelCancel implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public OrderModelCancel(OrderInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(OrderInfo recordInfo) {
		ModelOption_<OrderInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = OrderInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<OrderInfo> {		
		@Override public DeciTree<OrderInfo> getInstance(DeciTreeOption<OrderInfo> option) {
			return new RootOrderCancel(option);
		}			
	}
}
