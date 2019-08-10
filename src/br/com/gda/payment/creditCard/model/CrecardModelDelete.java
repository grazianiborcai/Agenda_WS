package br.com.gda.payment.creditCard.model;

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
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.decisionTree.RootCrecardDelete;


public final class CrecardModelDelete implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public CrecardModelDelete(CrecardInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(CrecardInfo recordInfo) {
		ModelOption_<CrecardInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = CrecardInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<CrecardInfo> {		
		@Override public DeciTree<CrecardInfo> getInstance(DeciTreeOption<CrecardInfo> option) {
			return new RootCrecardDelete(option);
		}			
	}
}
