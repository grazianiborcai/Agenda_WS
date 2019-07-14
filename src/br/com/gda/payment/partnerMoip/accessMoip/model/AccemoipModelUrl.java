package br.com.gda.payment.partnerMoip.accessMoip.model;

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
import br.com.gda.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.gda.payment.partnerMoip.accessMoip.model.decisionTree.RootAccemoipUrl;


public final class AccemoipModelUrl implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public AccemoipModelUrl(AccemoipInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(AccemoipInfo recordInfo) {
		ModelOption<AccemoipInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = AccemoipInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<AccemoipInfo> {		
		@Override public DeciTree<AccemoipInfo> getInstance(DeciTreeOption<AccemoipInfo> option) {
			return new RootAccemoipUrl(option);
		}			
	}
}
