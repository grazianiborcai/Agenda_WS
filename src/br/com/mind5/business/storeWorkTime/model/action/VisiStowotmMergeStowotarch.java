package br.com.mind5.business.storeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmMerger;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.decisionTree.RootStowotarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotmMergeStowotarch extends ActionVisitorTemplateMerge<StowotmInfo, StowotarchInfo> {
	
	public VisiStowotmMergeStowotarch(DeciTreeOption<StowotmInfo> option) {
		super(option, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotarchInfo>> getTreeClassHook() {
		return RootStowotarchSelect.class;
	}
	
	
	
	@Override protected List<StowotmInfo> mergeHook(List<StowotmInfo> baseInfos, List<StowotarchInfo> selectedInfos) {	
		return StowotmMerger.mergeWithStowotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
