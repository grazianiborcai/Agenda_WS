package br.com.mind5.business.scheduleDay.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.info.SchedayMerger;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusCopier;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.decisionTree.RootSchedatusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedayMergeSchedatus extends ActionVisitorTemplateMerge<SchedayInfo, SchedatusInfo> {
	
	public VisiSchedayMergeSchedatus(DeciTreeOption<SchedayInfo> option) {
		super(option, SchedatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedatusInfo>> getTreeClassHook() {
		return RootSchedatusSelect.class;
	}
	
	
	
	@Override protected List<SchedatusInfo> toActionClassHook(List<SchedayInfo> recordInfos) {
		return SchedatusCopier.copyFromScheday(recordInfos);
	}
	
	
	
	@Override protected List<SchedayInfo> mergeHook(List<SchedayInfo> baseInfos, List<SchedatusInfo> selectedInfos) {	
		return SchedayMerger.mergeWithSchedatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
