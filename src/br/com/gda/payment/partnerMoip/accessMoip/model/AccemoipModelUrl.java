package br.com.gda.payment.partnerMoip.accessMoip.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;
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
		ModelOption_<AccemoipInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = AccemoipInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper_.factory(helperOption, recordInfo);
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
