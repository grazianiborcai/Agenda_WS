package br.com.mind5.business.scheduleDayData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedaytaMergeToSelect extends ActionVisitorTemplateMergeV2<SchedaytaInfo, SchedaytaInfo> {
	
	public VisiSchedaytaMergeToSelect(DeciTreeOption<SchedaytaInfo> option) {
		super(option, SchedaytaInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchedaytaInfo>> getActionClassHook() {
		return StdSchedaytaDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedaytaInfo> mergeHook(List<SchedaytaInfo> baseInfos, List<SchedaytaInfo> selectedInfos) {	
		return SchedaytaMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
