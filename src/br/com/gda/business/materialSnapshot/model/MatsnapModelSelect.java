package br.com.gda.business.materialSnapshot.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatsnapSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatsnapModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public MatsnapModelSelect(MatsnapInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(MatsnapInfo recordInfo) {
		ModelOption<MatsnapInfo> helperOption = new ModelOption<>();
		
		helperOption.recordClass = MatsnapInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<MatsnapInfo> {		
		@Override public DeciTree<MatsnapInfo> getInstance(DeciTreeOption<MatsnapInfo> option) {
			return new RootMatsnapSelect(option);
		}		
	}
}
