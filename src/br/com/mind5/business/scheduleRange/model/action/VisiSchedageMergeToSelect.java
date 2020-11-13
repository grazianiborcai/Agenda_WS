package br.com.mind5.business.scheduleRange.model.action;

import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.info.SchedageMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedageMergeToSelect extends ActionVisitorTemplateMerge<SchedageInfo, SchedageInfo> {
	
	public VisiSchedageMergeToSelect(DeciTreeOption<SchedageInfo> option) {
		super(option, SchedageInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedageInfo>> getActionClassHook() {
		return StdSchedageDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedageInfo> mergeHook(List<SchedageInfo> baseInfos, List<SchedageInfo> selectedInfos) {	
		return SchedageMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
