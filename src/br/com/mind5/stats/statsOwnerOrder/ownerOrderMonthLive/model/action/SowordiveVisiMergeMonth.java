package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.MonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveMerger;

public final class SowordiveVisiMergeMonth extends ActionVisitorTemplateMerge<SowordiveInfo, MonthInfo> {
	
	public SowordiveVisiMergeMonth(DeciTreeOption<SowordiveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return MonthRootSelect.class;
	}
	
	
	
	@Override protected List<SowordiveInfo> mergeHook(List<SowordiveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SowordiveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
