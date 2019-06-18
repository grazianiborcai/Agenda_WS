package br.com.gda.payment.storePartner.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.decsionTree.RootStoparSelect;

public final class StoparModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public StoparModelSelect(StoparInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(StoparInfo recordInfo) {
		ModelOption<StoparInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = StoparInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<StoparInfo> {		
		@Override public DeciTree<StoparInfo> getInstance(DeciTreeOption<StoparInfo> option) {
			return new RootStoparSelect(option);
		}			
	}
}
