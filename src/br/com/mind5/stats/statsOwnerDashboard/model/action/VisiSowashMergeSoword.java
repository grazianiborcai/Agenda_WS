package br.com.mind5.stats.statsOwnerDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashMerger;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree.RootSowordSelectLtm;

final class VisiSowashMergeSoword extends ActionVisitorTemplateMerge<SowashInfo, SowordInfo> {
	
	public VisiSowashMergeSoword(DeciTreeOption<SowashInfo> option) {
		super(option, SowordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordInfo>> getTreeClassHook() {
		return RootSowordSelectLtm.class;
	}
	
	
	
	@Override protected List<SowashInfo> mergeHook(List<SowashInfo> baseInfos, List<SowordInfo> selectedInfos) {	
		return SowashMerger.mergeWithSoword(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
