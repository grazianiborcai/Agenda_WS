package br.com.gda.business.masterData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.AreaPhoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootAreaPhoneSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class AreaPhoneModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public AreaPhoneModelSelect(AreaPhoneInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(AreaPhoneInfo recordInfo) {
		ModelOption<AreaPhoneInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = AreaPhoneInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<AreaPhoneInfo> {		
		@Override public DeciTree<AreaPhoneInfo> getInstance(DeciTreeOption<AreaPhoneInfo> option) {
			return new RootAreaPhoneSelect(option);
		}			
	}
}
