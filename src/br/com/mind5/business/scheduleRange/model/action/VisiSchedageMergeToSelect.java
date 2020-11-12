package br.com.mind5.business.scheduleRange.model.action;

import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.info.SchedageMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedageMergeToSelect extends ActionVisitorTemplateMergeV2<SchedageInfo, SchedageInfo> {
	
	public VisiSchedageMergeToSelect(DeciTreeOption<SchedageInfo> option) {
		super(option, SchedageInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchedageInfo>> getActionClassHook() {
		return StdSchedageDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedageInfo> mergeHook(List<SchedageInfo> baseInfos, List<SchedageInfo> selectedInfos) {	
		return SchedageMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
