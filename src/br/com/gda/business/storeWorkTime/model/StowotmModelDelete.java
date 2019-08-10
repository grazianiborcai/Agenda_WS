package br.com.gda.business.storeWorkTime.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmDelete;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;

public final class StowotmModelDelete implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public StowotmModelDelete(StowotmInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(StowotmInfo recordInfo) {
		ModelOption_<StowotmInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = StowotmInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<StowotmInfo> {		
		@Override public DeciTree<StowotmInfo> getInstance(DeciTreeOption<StowotmInfo> option) {
			return new RootStowotmDelete(option);
		}
	}
}
