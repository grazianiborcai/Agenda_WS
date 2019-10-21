package br.com.mind5.business.storeTime_.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.mind5.business.storeTime_.info.StorimeInfo;
import br.com.mind5.business.storeTime_.model.decisionTree.RootStorimeSelect;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;

public final class StorimeModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public StorimeModelSelect(StorimeInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(StorimeInfo recordInfo) {
		ModelOption_<StorimeInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = StorimeInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<StorimeInfo> {		
		@Override public DeciTree<StorimeInfo> getInstance(DeciTreeOption<StorimeInfo> option) {
			return new RootStorimeSelect(option);
		}			
	}
}
