package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.decisionTree.RootSchedatusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeSchedatus extends ActionVisitorTemplateMergeV2<SchedineInfo, SchedatusInfo> {
	
	public VisiSchedineMergeSchedatus(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedatusInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedatusInfo>> getTreeClassHook() {
		return RootSchedatusSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<SchedatusInfo> selectedInfos) {	
		return SchedineMerger.mergeWithSchedatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
