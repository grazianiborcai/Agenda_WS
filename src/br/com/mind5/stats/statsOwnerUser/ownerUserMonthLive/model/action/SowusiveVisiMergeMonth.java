package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.MonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveMerger;

public final class SowusiveVisiMergeMonth extends ActionVisitorTemplateMerge<SowusiveInfo, MonthInfo> {
	
	public SowusiveVisiMergeMonth(DeciTreeOption<SowusiveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return MonthRootSelect.class;
	}
	
	
	
	@Override protected List<SowusiveInfo> mergeHook(List<SowusiveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SowusiveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
