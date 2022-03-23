package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.model.decisionTree.RootSchedauthSearch;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiMergeSchedauth extends ActionVisitorTemplateMerge<SchedineInfo, SchedauthInfo> {
	
	public SchedineVisiMergeSchedauth(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedauthInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedauthInfo>> getTreeClassHook() {
		return RootSchedauthSearch.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<SchedauthInfo> selectedInfos) {	
		return SchedineMerger.mergeWithSchedauth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
