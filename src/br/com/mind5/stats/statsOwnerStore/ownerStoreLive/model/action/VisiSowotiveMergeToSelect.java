package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveMerger;

final class VisiSowotiveMergeToSelect extends ActionVisitorTemplateMerge<SowotiveInfo, SowotiveInfo> {
	
	public VisiSowotiveMergeToSelect(DeciTreeOption<SowotiveInfo> option) {
		super(option, SowotiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SowotiveInfo>> getActionClassHook() {
		return StdSowotiveDaoSelect.class;
	}
	
	
	
	@Override protected List<SowotiveInfo> mergeHook(List<SowotiveInfo> baseInfos, List<SowotiveInfo> selectedInfos) {	
		return SowotiveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
