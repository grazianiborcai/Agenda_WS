package br.com.gda.payment.permissionMoip.model;

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
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionMoip.model.decisionTree.RootPeresmoipCode;


public final class PeresmoipModelCode implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PeresmoipModelCode(PeresmoipInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PeresmoipInfo recordInfo) {
		ModelOption<PeresmoipInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PeresmoipInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PeresmoipInfo> {		
		@Override public DeciTree<PeresmoipInfo> getInstance(DeciTreeOption<PeresmoipInfo> option) {
			return new RootPeresmoipCode(option);
		}			
	}
}
