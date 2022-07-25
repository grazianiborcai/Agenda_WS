package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.decisionTree.SchedatusRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiMergeSchedatus extends ActionVisitorTemplateMerge<SchedineInfo, SchedatusInfo> {
	
	public SchedineVisiMergeSchedatus(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedatusInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedatusInfo>> getTreeClassHook() {
		return SchedatusRootSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<SchedatusInfo> selectedInfos) {	
		return SchedineMerger.mergeWithSchedatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
