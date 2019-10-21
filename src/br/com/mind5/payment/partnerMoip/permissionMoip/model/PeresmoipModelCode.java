package br.com.mind5.payment.partnerMoip.permissionMoip.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.decisionTree.RootPeresmoipCode;


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
		ModelOption_<PeresmoipInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = PeresmoipInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PeresmoipInfo> {		
		@Override public DeciTree<PeresmoipInfo> getInstance(DeciTreeOption<PeresmoipInfo> option) {
			return new RootPeresmoipCode(option);
		}			
	}
}
