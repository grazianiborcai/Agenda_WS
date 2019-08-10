package br.com.gda.business.form.formAddress.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.model.decisionTree.RootFormAddressSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;

public final class FormAddressModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public FormAddressModelSelect(FormAddressInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(FormAddressInfo recordInfo) {
		ModelOption_<FormAddressInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = FormAddressInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<FormAddressInfo> {		
		@Override public DeciTree<FormAddressInfo> getInstance(DeciTreeOption<FormAddressInfo> option) {
			return new RootFormAddressSelect(option);
		}			
	}
}
