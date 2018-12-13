package br.com.gda.business.personCustomer.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.decisionTree.RootPersonCusSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PersonCusModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PersonCusModelSelect(PersonCusInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PersonCusInfo recordInfo) {
		ModelOption<PersonCusInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PersonCusInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PersonCusInfo> {		
		@Override public DeciTree<PersonCusInfo> getInstance(DeciTreeOption<PersonCusInfo> option) {
			return new RootPersonCusSelect(option);
		}		
	}
}
