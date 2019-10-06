package br.com.gda.business.employeeWorkTimeOutlier.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.business.employeeWorkTimeOutlier.model.decisionTree.RootEmpwoutSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;

public final class EmpwoutModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmpwoutModelSelect(EmpwoutInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(EmpwoutInfo recordInfo) {
		ModelOption_<EmpwoutInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = EmpwoutInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<EmpwoutInfo> {		
		@Override public DeciTree<EmpwoutInfo> getInstance(DeciTreeOption<EmpwoutInfo> option) {
			return new RootEmpwoutSelect(option);
		}			
	}
}
