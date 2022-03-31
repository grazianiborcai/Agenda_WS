package br.com.mind5.business.storeProspect.model.action;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.info.StoprosMerger;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.masterData.prospectStatus.model.decisionTree.RootProstusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosVisiMergeProstus extends ActionVisitorTemplateMerge<StoprosInfo, ProstusInfo> {
	
	public StoprosVisiMergeProstus(DeciTreeOption<StoprosInfo> option) {
		super(option, ProstusInfo.class);
	}
	
	
	
	protected Class<? extends DeciTree<ProstusInfo>> getTreeClassHook() {
		return RootProstusSelect.class;
	}
	
	
	
	@Override protected List<StoprosInfo> mergeHook(List<StoprosInfo> baseInfos, List<ProstusInfo> selectedInfos) {	
		return StoprosMerger.mergeWithProstus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}	
}
