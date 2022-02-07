package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveMerger;

final class VisiSowordiveMergeMonth extends ActionVisitorTemplateMerge<SowordiveInfo, MonthInfo> {
	
	public VisiSowordiveMergeMonth(DeciTreeOption<SowordiveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}
	
	
	
	@Override protected List<SowordiveInfo> mergeHook(List<SowordiveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SowordiveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
