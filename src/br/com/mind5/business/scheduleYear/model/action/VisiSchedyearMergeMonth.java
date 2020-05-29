package br.com.mind5.business.scheduleYear.model.action;

import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.info.SchedyearMerger;
import br.com.mind5.masterData.month.info.MonthCopier;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedyearMergeMonth extends ActionVisitorTemplateMergeV2<SchedyearInfo, MonthInfo> {
	
	public VisiSchedyearMergeMonth(DeciTreeOption<SchedyearInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}
	
	
	
	@Override protected List<MonthInfo> toActionClassHook(List<SchedyearInfo> recordInfos) {
		return MonthCopier.copyFromSchedyear(recordInfos);
	}
	
	
	
	@Override protected List<SchedyearInfo> mergeHook(List<SchedyearInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SchedyearMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
