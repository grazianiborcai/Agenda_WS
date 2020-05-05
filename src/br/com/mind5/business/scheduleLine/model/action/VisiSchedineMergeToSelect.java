package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeToSelect extends ActionVisitorTemplateMergeV2<SchedineInfo, SchedineInfo> {
	
	public VisiSchedineMergeToSelect(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchedineInfo>> getActionClassHook() {
		return StdSchedineDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {	
		return SchedineMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
