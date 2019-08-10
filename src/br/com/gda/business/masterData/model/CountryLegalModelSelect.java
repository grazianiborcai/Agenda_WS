package br.com.gda.business.masterData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCountryLegalSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;

public final class CountryLegalModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public CountryLegalModelSelect(CountryLegalInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(CountryLegalInfo recordInfo) {
		ModelOption_<CountryLegalInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = CountryLegalInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<CountryLegalInfo> {		
		@Override public DeciTree<CountryLegalInfo> getInstance(DeciTreeOption<CountryLegalInfo> option) {
			return new RootCountryLegalSelect(option);
		}			
	}
}
