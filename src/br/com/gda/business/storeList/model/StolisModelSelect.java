package br.com.gda.business.storeList.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;

public final class StolisModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public StolisModelSelect(StolisInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(StolisInfo recordInfo) {
		ModelOption_<StolisInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = StolisInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<StolisInfo> {		
		@Override public DeciTree<StolisInfo> getInstance(DeciTreeOption<StolisInfo> option) {
			return new RootStolisSelect(option);
		}			
	}
}
