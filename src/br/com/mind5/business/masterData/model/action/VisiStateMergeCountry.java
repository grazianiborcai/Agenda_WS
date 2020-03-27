package br.com.mind5.business.masterData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.business.masterData.info.StateMerger;
import br.com.mind5.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStateMergeCountry extends ActionVisitorTemplateMerge<StateInfo, CountryInfo> {
	
	public VisiStateMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return RootCountrySelect.class;
	}
	
	
	
	@Override protected List<StateInfo> mergeHook(List<StateInfo> recordInfos, List<CountryInfo> selectedInfos) {	
		return StateMerger.mergeWithCountry(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
