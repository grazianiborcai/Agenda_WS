package br.com.gda.business.feeOwner.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.model.decisionTree.RootFeewnerSelectService;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FeewnerModelSelectService implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public FeewnerModelSelectService(FeewnerInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(FeewnerInfo recordInfo) {
		ModelOption<FeewnerInfo> helperOption = new ModelOption<>();
		
		helperOption.recordClass = FeewnerInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<FeewnerInfo> {		
		@Override public DeciTree<FeewnerInfo> getInstance(DeciTreeOption<FeewnerInfo> option) {
			return new RootFeewnerSelectService(option);
		}			
	}
}
