package br.com.mind5.business.scheduleDay.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.info.SchedayMerger;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.decisionTree.SchedaytaRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedayVisiMergeSchedayta extends ActionVisitorTemplateMerge<SchedayInfo, SchedaytaInfo> {
	
	public SchedayVisiMergeSchedayta(DeciTreeOption<SchedayInfo> option) {
		super(option, SchedaytaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedaytaInfo>> getTreeClassHook() {
		return SchedaytaRootSelect.class;
	}
	
	
	
	@Override protected List<SchedayInfo> mergeHook(List<SchedayInfo> baseInfos, List<SchedaytaInfo> selectedInfos) {	
		return SchedayMerger.mergeWithSchedayta(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
