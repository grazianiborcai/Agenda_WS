package br.com.mind5.masterData.state.model.action;

import java.util.List;

import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.decisionTree.CountryRootSelect;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.info.StateMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StateVisiMergeCountry extends ActionVisitorTemplateMerge<StateInfo, CountryInfo> {
	
	public StateVisiMergeCountry(DeciTreeOption<StateInfo> option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return CountryRootSelect.class;
	}
	
	
	
	@Override protected List<StateInfo> mergeHook(List<StateInfo> baseInfos, List<CountryInfo> selectedInfos) {	
		return StateMerger.mergeWithCountry(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
