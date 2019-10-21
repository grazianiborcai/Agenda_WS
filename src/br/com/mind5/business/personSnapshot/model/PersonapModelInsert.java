package br.com.mind5.business.personSnapshot.model;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.RootPersonapInsert;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;

public final class PersonapModelInsert implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PersonapModelInsert(String incomingData, HttpServletRequest request) {
		initialize();
		buildHelper(incomingData, request);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(String incomingData, HttpServletRequest request) {
		ModelOption_<PersonapInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = PersonapInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PersonapInfo> {		
		@Override public DeciTree<PersonapInfo> getInstance(DeciTreeOption<PersonapInfo> option) {
			return new RootPersonapInsert(option);
		}			
	}
}
