package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveMerger;

public final class CustamoniveVisiMergeToSelect extends ActionVisitorTemplateMerge<CustamoniveInfo, CustamoniveInfo> {
	
	public CustamoniveVisiMergeToSelect(DeciTreeOption<CustamoniveInfo> option) {
		super(option, CustamoniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CustamoniveInfo>> getVisitorClassHook() {
		return CustamoniveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CustamoniveInfo> mergeHook(List<CustamoniveInfo> baseInfos, List<CustamoniveInfo> selectedInfos) {	
		return CustamoniveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
