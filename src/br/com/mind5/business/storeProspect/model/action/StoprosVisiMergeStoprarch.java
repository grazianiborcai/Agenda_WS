package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosMerger;
import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.model.decisionTree.StoprarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosVisiMergeStoprarch extends ActionVisitorTemplateMerge<StoprosInfo, StoprarchInfo> {
	
	public StoprosVisiMergeStoprarch(DeciTreeOption<StoprosInfo> option) {
		super(option, StoprarchInfo.class);
	}
	
	
	
	protected Class<? extends DeciTree<StoprarchInfo>> getTreeClassHook() {
		return StoprarchRootSelect.class;
	}
	
	
	
	@Override protected List<StoprosInfo> mergeHook(List<StoprosInfo> baseInfos, List<StoprarchInfo> selectedInfos) {	
		return StoprosMerger.mergeWithStoprarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
