package br.com.gda.business.masterData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.model.decisionTree.LanguRootSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LanguModelSelect implements Model {
	private ModelHelper<LanguInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public LanguModelSelect(LanguInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(LanguInfo recordInfo) {
		ModelOption<LanguInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = LanguInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = new ModelHelper<>(helperOption, recordInfo);
	}


	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<LanguInfo> {		
		@Override public DeciTree<LanguInfo> getDecisionTree(DeciTreeOption<LanguInfo> option) {
			return new LanguRootSelect(option);
		}		
	
	}
}
