package br.com.mind5.business.orderReserve.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.decisionTree.RootOrderveSelect;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;

public final class OrderveModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public OrderveModelSelect(OrderveInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(OrderveInfo recordInfo) {
		ModelOption_<OrderveInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = OrderveInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<OrderveInfo> {		
		@Override public DeciTree<OrderveInfo> getInstance(DeciTreeOption<OrderveInfo> option) {
			return new RootOrderveSelect(option);
		}			
	}
}
