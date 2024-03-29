package br.com.mind5.stats.statsOwnerDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashMerger;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree.SowedulRootSelectLtm;

public final class SowashVisiMergeSowedul extends ActionVisitorTemplateMerge<SowashInfo, SowedulInfo> {
	
	public SowashVisiMergeSowedul(DeciTreeOption<SowashInfo> option) {
		super(option, SowedulInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedulInfo>> getTreeClassHook() {
		return SowedulRootSelectLtm.class;
	}
	
	
	
	@Override protected List<SowashInfo> mergeHook(List<SowashInfo> baseInfos, List<SowedulInfo> selectedInfos) {	
		return SowashMerger.mergeWithSowedul(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
