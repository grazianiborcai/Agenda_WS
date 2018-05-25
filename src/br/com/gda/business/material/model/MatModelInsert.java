package br.com.gda.business.material.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatInsert;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatModelInsert implements Model {
	private ModelHelper<MatInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public MatModelInsert(String incomingData) {
		initialize();
		buildHelper(incomingData);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(String incomingData) {
		ModelOption<MatInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = MatInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = new ModelHelper<>(helperOption, incomingData);
	}


	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<MatInfo> {		
		@Override public DeciTree<MatInfo> getInstance(DeciTreeOption<MatInfo> option) {
			return new RootMatInsert(option);
		}			
	}
}
