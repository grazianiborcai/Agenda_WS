package br.com.mind5.business.cartReserve.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.RootCarterveSelect;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;

public final class CarterveModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public CarterveModelSelect(CarterveInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(CarterveInfo recordInfo) {
		ModelOption_<CarterveInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = CarterveInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<CarterveInfo> {		
		@Override public DeciTree<CarterveInfo> getInstance(DeciTreeOption<CarterveInfo> option) {
			return new RootCarterveSelect(option);
		}			
	}
}
