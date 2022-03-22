package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonMerger;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.decisionTree.CustamoniveRootSelect;

public final class CustamonVisiMergeCustamonive extends ActionVisitorTemplateMerge<CustamonInfo, CustamoniveInfo> {
	
	public CustamonVisiMergeCustamonive(DeciTreeOption<CustamonInfo> option) {
		super(option, CustamoniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustamoniveInfo>> getTreeClassHook() {
		return CustamoniveRootSelect.class;
	}
	
	
	
	@Override protected List<CustamonInfo> mergeHook(List<CustamonInfo> baseInfos, List<CustamoniveInfo> selectedInfos) {	
		return CustamonMerger.mergeWithStedmonive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
