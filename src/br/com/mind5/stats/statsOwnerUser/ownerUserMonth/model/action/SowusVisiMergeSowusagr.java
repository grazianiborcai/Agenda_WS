package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusMerger;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.decisionTree.SowusagrRootSelect;

public final class SowusVisiMergeSowusagr extends ActionVisitorTemplateMerge<SowusInfo, SowusagrInfo> {
	
	public SowusVisiMergeSowusagr(DeciTreeOption<SowusInfo> option) {
		super(option, SowusagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusagrInfo>> getTreeClassHook() {
		return SowusagrRootSelect.class;
	}
	
	
	
	@Override protected List<SowusInfo> mergeHook(List<SowusInfo> baseInfos, List<SowusagrInfo> selectedInfos) {	
		return SowusMerger.mergeWithSowusagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
