package br.com.gda.business.masterData.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.masterData.info.StateMerger;
import br.com.gda.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStateMergeCountry extends ActionVisitorTemplateMerge_<StateInfo, CountryInfo> {
	
	public VisiStateMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return RootCountrySelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StateInfo>> getMergerClassHook() {
		return StateMerger.class;
	}
}
