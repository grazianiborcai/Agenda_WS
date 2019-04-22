package br.com.gda.business.customerSearch.model;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
		ModelOption<CusarchInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = CusarchInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper.factory(helperOption, incomingData, request);
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
