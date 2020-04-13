package br.com.mind5.masterData.state.model.action;

import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCountrySelect;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.info.StateMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStateMergeCountry extends ActionVisitorTemplateMergeV2<StateInfo, CountryInfo> {
	
	public VisiStateMergeCountry(DeciTreeOption<StateInfo> option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return RootCountrySelect.class;
	}
	
	
	
	@Override protected List<StateInfo> mergeHook(List<StateInfo> baseInfos, List<CountryInfo> selectedInfos) {	
		return StateMerger.mergeWithCountry(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
