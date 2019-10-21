package br.com.mind5.business.materialMovement.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.decisionTree.RootMatmovSelect;
import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;

public final class MatmovModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public MatmovModelSelect(MatmovInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(MatmovInfo recordInfo) {
		ModelOption_<MatmovInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = MatmovInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<MatmovInfo> {		
		@Override public DeciTree<MatmovInfo> getInstance(DeciTreeOption<MatmovInfo> option) {
			return new RootMatmovSelect(option);
		}			
	}
}
