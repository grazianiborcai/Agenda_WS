package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.decisionTree.SchedarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiMergeSchedarch extends ActionVisitorTemplateMerge<SchedineInfo, SchedarchInfo> {
	
	public SchedineVisiMergeSchedarch(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedarchInfo>> getTreeClassHook() {
		return SchedarchRootSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<SchedarchInfo> selectedInfos) {	
		return SchedineInfo.copyFrom(selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
