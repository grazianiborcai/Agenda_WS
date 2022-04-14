package br.com.mind5.business.storeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmMerger;
import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSearch.model.decisionTree.StuntmarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiMergeStuntmarch_ extends ActionVisitorTemplateMerge<StuntmInfo, StuntmarchInfo> {
	
	public StuntmVisiMergeStuntmarch_(DeciTreeOption<StuntmInfo> option) {
		super(option, StuntmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmarchInfo>> getTreeClassHook() {
		return StuntmarchRootSelect.class;
	}
	
	
	
	@Override protected List<StuntmInfo> mergeHook(List<StuntmInfo> baseInfos, List<StuntmarchInfo> selectedInfos) {	
		return StuntmMerger.mergeWithStuntmarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
