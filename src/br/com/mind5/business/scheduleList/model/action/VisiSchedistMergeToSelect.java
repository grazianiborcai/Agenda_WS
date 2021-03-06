package br.com.mind5.business.scheduleList.model.action;

import java.util.List;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.business.scheduleList.info.SchedistMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedistMergeToSelect extends ActionVisitorTemplateMerge<SchedistInfo, SchedistInfo> {
	
	public VisiSchedistMergeToSelect(DeciTreeOption<SchedistInfo> option) {
		super(option, SchedistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedistInfo>> getActionClassHook() {
		return StdSchedistDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedistInfo> mergeHook(List<SchedistInfo> baseInfos, List<SchedistInfo> selectedInfos) {	
		return SchedistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
