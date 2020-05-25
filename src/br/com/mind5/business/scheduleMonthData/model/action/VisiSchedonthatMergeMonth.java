package br.com.mind5.business.scheduleMonthData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatMerger;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedonthatMergeMonth extends ActionVisitorTemplateMergeV2<SchedonthatInfo, MonthInfo> {

	public VisiSchedonthatMergeMonth(DeciTreeOption<SchedonthatInfo> option) {
		super(option, MonthInfo.class);
	}

	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}

	
	
	@Override protected List<SchedonthatInfo> mergeHook(List<SchedonthatInfo> baseInfos, List<MonthInfo> selectedInfos) {
		return SchedonthatMerger.mergeWithMonth(baseInfos, selectedInfos);
	}

	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
