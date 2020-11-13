package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeToMove extends ActionVisitorTemplateMerge<SchedineInfo, SchedineInfo> {
	
	public VisiSchedineMergeToMove(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedineInfo>> getActionClassHook() {
		return StdSchedineDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {	
		return SchedineMerger.mergeToMove(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
