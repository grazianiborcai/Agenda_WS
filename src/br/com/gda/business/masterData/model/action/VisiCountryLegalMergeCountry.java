package br.com.gda.business.masterData.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.business.masterData.info.CountryLegalMerger;
import br.com.gda.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCountryLegalMergeCountry extends ActionVisitorTemplateMerge<CountryLegalInfo, CountryInfo> {
	
	public VisiCountryLegalMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return RootCountrySelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CountryLegalInfo>> getMergerClassHook() {
		return CountryLegalMerger.class;
	}
}
