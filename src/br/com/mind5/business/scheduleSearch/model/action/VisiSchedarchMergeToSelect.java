package br.com.mind5.business.scheduleSearch.model.action;

import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedarchMergeToSelect extends ActionVisitorTemplateMerge<SchedarchInfo, SchedarchInfo> {
	
	public VisiSchedarchMergeToSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option, SchedarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedarchInfo>> getActionClassHook() {
		return StdSchedarchDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedarchInfo> mergeHook(List<SchedarchInfo> baseInfos, List<SchedarchInfo> selectedInfos) {	
		return SchedarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
