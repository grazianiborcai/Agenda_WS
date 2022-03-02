package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusMerger;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.decisionTree.SowusiveRootSelect;

public final class SowusVisiMergeSowusive extends ActionVisitorTemplateMerge<SowusInfo, SowusiveInfo> {
	
	public SowusVisiMergeSowusive(DeciTreeOption<SowusInfo> option) {
		super(option, SowusiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusiveInfo>> getTreeClassHook() {
		return SowusiveRootSelect.class;
	}
	
	
	
	@Override protected List<SowusInfo> mergeHook(List<SowusInfo> baseInfos, List<SowusiveInfo> selectedInfos) {	
		return SowusMerger.mergeWithSowusive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
