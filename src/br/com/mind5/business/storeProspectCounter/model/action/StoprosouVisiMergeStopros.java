package br.com.mind5.business.storeProspectCounter.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.decisionTree.StoprosRootSearchCreated;
import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.business.storeProspectCounter.info.StoprosouMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosouVisiMergeStopros extends ActionVisitorTemplateMerge<StoprosouInfo, StoprosInfo> {
	
	public StoprosouVisiMergeStopros(DeciTreeOption<StoprosouInfo> option) {
		super(option, StoprosInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoprosInfo>> getTreeClassHook() {
		return StoprosRootSearchCreated.class;
	}
	
	
	
	@Override protected List<StoprosouInfo> mergeHook(List<StoprosouInfo> baseInfos, List<StoprosInfo> selectedInfos) {	
		return StoprosouMerger.mergeWithStopros(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
