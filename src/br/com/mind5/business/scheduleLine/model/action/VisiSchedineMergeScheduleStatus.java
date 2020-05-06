package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootScheduleStatusSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergeScheduleStatus extends ActionVisitorTemplateMergeV2<SchedineInfo, ScheduleStatusInfo> {
	
	public VisiSchedineMergeScheduleStatus(DeciTreeOption<SchedineInfo> option) {
		super(option, ScheduleStatusInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<ScheduleStatusInfo>> getTreeClassHook() {
		return RootScheduleStatusSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<ScheduleStatusInfo> selectedInfos) {	
		return SchedineMerger.mergeWithScheduleStatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
