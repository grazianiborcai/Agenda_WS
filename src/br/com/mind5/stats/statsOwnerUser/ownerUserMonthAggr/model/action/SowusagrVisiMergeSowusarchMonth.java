package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrMerger;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.decisionTree.SowusarchRootSelectMonth;

public final class SowusagrVisiMergeSowusarchMonth extends ActionVisitorTemplateMerge<SowusagrInfo, SowusarchInfo> {
	
	public SowusagrVisiMergeSowusarchMonth(DeciTreeOption<SowusagrInfo> option) {
		super(option,SowusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusarchInfo>> getTreeClassHook() {
		return SowusarchRootSelectMonth.class;
	}
	
	
	
	@Override protected List<SowusagrInfo> mergeHook(List<SowusagrInfo> baseInfos, List<SowusarchInfo> selectedInfos) {	
		return SowusagrMerger.mergeWithSowusarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
