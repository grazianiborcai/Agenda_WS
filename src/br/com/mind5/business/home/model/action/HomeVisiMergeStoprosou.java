package br.com.mind5.business.home.model.action;

import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.info.HomeMerger;
import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.business.storeProspectCounter.model.decisionTree.StoprosouRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class HomeVisiMergeStoprosou extends ActionVisitorTemplateMerge<HomeInfo, StoprosouInfo> {
	
	public HomeVisiMergeStoprosou(DeciTreeOption<HomeInfo> option) {
		super(option, StoprosouInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoprosouInfo>> getTreeClassHook() {
		return StoprosouRootSelect.class;
	}
	
	
	
	@Override protected List<HomeInfo> mergeHook(List<HomeInfo> baseInfos, List<StoprosouInfo> selectedInfos) {	
		return HomeMerger.mergeWithStoprosou(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
