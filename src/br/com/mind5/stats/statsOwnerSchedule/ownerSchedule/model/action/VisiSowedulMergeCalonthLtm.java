package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelectLtm;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulMerger;

final class VisiSowedulMergeCalonthLtm extends ActionVisitorTemplateMerge<SowedulInfo, CalonthInfo> {
	
	public VisiSowedulMergeCalonthLtm(DeciTreeOption<SowedulInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelectLtm.class;
	}
	
	
	
	@Override protected List<SowedulInfo> mergeHook(List<SowedulInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return SowedulMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
