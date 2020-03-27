package br.com.mind5.business.masterData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.business.masterData.info.CountryLegalMerger;
import br.com.mind5.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCountryLegalMergeCountry extends ActionVisitorTemplateMerge<CountryLegalInfo, CountryInfo> {
	
	public VisiCountryLegalMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return RootCountrySelect.class;
	}
	
	
	
	@Override protected List<CountryLegalInfo> mergeHook(List<CountryLegalInfo> recordInfos, List<CountryInfo> selectedInfos) {	
		return CountryLegalMerger.mergeWithCountry(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
