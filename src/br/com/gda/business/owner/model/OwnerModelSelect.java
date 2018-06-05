package br.com.gda.business.owner.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.decisionTree.RootOwnerSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OwnerModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public OwnerModelSelect(OwnerInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(OwnerInfo recordInfo) {
		ModelOption<OwnerInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = OwnerInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<OwnerInfo> {		
		@Override public DeciTree<OwnerInfo> getInstance(DeciTreeOption<OwnerInfo> option) {
			return new RootOwnerSelect(option);
		}			
	}
}
