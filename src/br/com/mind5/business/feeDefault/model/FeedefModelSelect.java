package br.com.mind5.business.feeDefault.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.business.feeDefault.model.decisionTree.RootFeedefSelect;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;

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
		ModelOption_<FeedefInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = FeedefInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<FeedefInfo> {		
		@Override public DeciTree<FeedefInfo> getInstance(DeciTreeOption<FeedefInfo> option) {
			return new RootFeedefSelect(option);
		}			
	}
}
