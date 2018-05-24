package br.com.gda.business.masterData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.decisionTree.MatUnitRootSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatUnitModelSelect implements Model {
	private ModelHelper<MatUnitInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public MatUnitModelSelect(MatUnitInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(MatUnitInfo recordInfo) {
		ModelOption<MatUnitInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = MatUnitInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = new ModelHelper<>(helperOption, recordInfo);
	}


	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<MatUnitInfo> {		
		@Override public DeciTree<MatUnitInfo> getInstance(DeciTreeOption<MatUnitInfo> option) {
			return new MatUnitRootSelect(option);
		}		
	
	}
}
