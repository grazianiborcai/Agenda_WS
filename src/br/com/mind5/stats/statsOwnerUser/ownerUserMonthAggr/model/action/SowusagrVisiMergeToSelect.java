package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrMerger;

public final class SowusagrVisiMergeToSelect extends ActionVisitorTemplateMerge<SowusagrInfo, SowusagrInfo> {
	
	public SowusagrVisiMergeToSelect(DeciTreeOption<SowusagrInfo> option) {
		super(option, SowusagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowusagrInfo>> getVisitorClassHook() {
		return SowusagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowusagrInfo> mergeHook(List<SowusagrInfo> baseInfos, List<SowusagrInfo> selectedInfos) {	
		return SowusagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
