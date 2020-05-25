package br.com.mind5.business.scheduleDayData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.decisionTree.RootSchedarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedaytaMergeSchedarch extends ActionVisitorTemplateMergeV2<SchedaytaInfo, SchedarchInfo> {
	
	public VisiSchedaytaMergeSchedarch(DeciTreeOption<SchedaytaInfo> option) {
		super(option, SchedarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedarchInfo>> getTreeClassHook() {
		return RootSchedarchSelect.class;
	}
	
	
	
	@Override protected List<SchedaytaInfo> mergeHook(List<SchedaytaInfo> baseInfos, List<SchedarchInfo> selectedInfos) {	
		return SchedaytaInfo.copyFrom(selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
