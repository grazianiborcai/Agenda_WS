package br.com.mind5.authorization.scheduleAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class VisiSchedauthMergeToSelect extends ActionVisitorTemplateMerge<SchedauthInfo, SchedauthInfo> {
	
	public VisiSchedauthMergeToSelect(DeciTreeOption<SchedauthInfo> option) {
		super(option, SchedauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchedauthInfo>> getVisitorClassHook() {
		return VisiSchedauthDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedauthInfo> mergeHook(List<SchedauthInfo> baseInfos, List<SchedauthInfo> selectedInfos) {	
		return SchedauthMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
