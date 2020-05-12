package br.com.mind5.business.scheduleSearch.model.action;

import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedarchMergeToSelect extends ActionVisitorTemplateMergeV2<SchedarchInfo, SchedarchInfo> {
	
	public VisiSchedarchMergeToSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option, SchedarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchedarchInfo>> getActionClassHook() {
		return StdSchedarchDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedarchInfo> mergeHook(List<SchedarchInfo> baseInfos, List<SchedarchInfo> selectedInfos) {	
		return SchedarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
