package br.com.gda.business.masterData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.masterData.info.StateMerger;
import br.com.gda.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStateMergeCountry extends ActionVisitorTemplateMergeV2<StateInfo, CountryInfo> {
	
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
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
