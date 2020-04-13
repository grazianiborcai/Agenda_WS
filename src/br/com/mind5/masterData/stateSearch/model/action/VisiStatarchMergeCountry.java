package br.com.mind5.masterData.stateSearch.model.action;

import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.info.StatarchMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStatarchMergeCountry extends ActionVisitorTemplateMergeV2<StatarchInfo, CountryInfo> {
	
	public VisiStatarchMergeCountry(DeciTreeOption<StatarchInfo> option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return RootCountrySelect.class;
	}
	
	
	
	@Override protected List<StatarchInfo> mergeHook(List<StatarchInfo> baseInfos, List<CountryInfo> selectedInfos) {	
		return StatarchMerger.mergeWithCountry(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}