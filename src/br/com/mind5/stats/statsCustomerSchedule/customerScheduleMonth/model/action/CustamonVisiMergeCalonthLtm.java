package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelectLtmNow;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonMerger;

public final class CustamonVisiMergeCalonthLtm extends ActionVisitorTemplateMerge<CustamonInfo, CalonthInfo> {
	
	public CustamonVisiMergeCalonthLtm(DeciTreeOption<CustamonInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelectLtmNow.class;
	}
	
	
	
	@Override protected List<CustamonInfo> mergeHook(List<CustamonInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return CustamonMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
