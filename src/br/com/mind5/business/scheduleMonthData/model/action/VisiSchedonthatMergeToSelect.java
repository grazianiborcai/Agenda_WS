package br.com.mind5.business.scheduleMonthData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedonthatMergeToSelect extends ActionVisitorTemplateMerge<SchedonthatInfo, SchedonthatInfo> {
	
	public VisiSchedonthatMergeToSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option, SchedonthatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedonthatInfo>> getActionClassHook() {
		return StdSchedonthatDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedonthatInfo> mergeHook(List<SchedonthatInfo> baseInfos, List<SchedonthatInfo> selectedInfos) {	
		return SchedonthatMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
