package br.com.gda.business.masterData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatmovTypeSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;

public final class MatmovTypeModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public MatmovTypeModelSelect(MatmovTypeInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(MatmovTypeInfo recordInfo) {
		ModelOption_<MatmovTypeInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = MatmovTypeInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<MatmovTypeInfo> {		
		@Override public DeciTree<MatmovTypeInfo> getInstance(DeciTreeOption<MatmovTypeInfo> option) {
			return new RootMatmovTypeSelect(option);
		}			
	}
}
