package br.com.gda.payment.ownerPartner.model;

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
import br.com.gda.payment.ownerPartner.info.OwnparInfo;
import br.com.gda.payment.ownerPartner.model.decisionTree.RootOwnparSelect;

public final class OwnparModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public OwnparModelSelect(OwnparInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(OwnparInfo recordInfo) {
		ModelOption<OwnparInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = OwnparInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<OwnparInfo> {		
		@Override public DeciTree<OwnparInfo> getInstance(DeciTreeOption<OwnparInfo> option) {
			return new RootOwnparSelect(option);
		}			
	}
}
