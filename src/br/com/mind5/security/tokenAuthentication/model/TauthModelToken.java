package br.com.mind5.security.tokenAuthentication.model;

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
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.model.decisionTree.RootTauthToken;

public final class TauthModelToken implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public TauthModelToken(TauthInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(TauthInfo recordInfo) {
		ModelOption_<TauthInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = TauthInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<TauthInfo> {		
		@Override public DeciTree<TauthInfo> getInstance(DeciTreeOption<TauthInfo> option) {
			return new RootTauthToken(option);
		}		
	}
}
