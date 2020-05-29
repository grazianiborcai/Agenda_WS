package br.com.mind5.business.scheduleYearData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.info.SchedyeratMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedyeratMergeToSelect extends ActionVisitorTemplateMergeV2<SchedyeratInfo, SchedyeratInfo> {
	
	public VisiSchedyeratMergeToSelect(DeciTreeOption<SchedyeratInfo> option) {
		super(option, SchedyeratInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchedyeratInfo>> getActionClassHook() {
		return StdSchedyeratDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedyeratInfo> mergeHook(List<SchedyeratInfo> baseInfos, List<SchedyeratInfo> selectedInfos) {	
		return SchedyeratMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
