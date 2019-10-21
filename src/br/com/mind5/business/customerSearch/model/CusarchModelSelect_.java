package br.com.mind5.business.customerSearch.model;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;

public final class CusarchModelSelect_ implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public CusarchModelSelect_(String incomingData, HttpServletRequest request) {
		initialize();
		buildHelper(incomingData, request);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(String incomingData, HttpServletRequest request) {
		ModelOption_<CusarchInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = CusarchInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper_.factory(helperOption, incomingData, request);
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<CusarchInfo> {		
		@Override public DeciTree<CusarchInfo> getInstance(DeciTreeOption<CusarchInfo> option) {
			return new RootCusarchSelect(option);
		}		
	}
}
