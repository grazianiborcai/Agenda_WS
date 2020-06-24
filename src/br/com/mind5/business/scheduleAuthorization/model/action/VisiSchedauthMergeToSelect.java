package br.com.mind5.business.scheduleAuthorization.model.action;

import java.util.List;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleAuthorization.info.SchedauthMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedauthMergeToSelect extends ActionVisitorTemplateMergeV2<SchedauthInfo, SchedauthInfo> {
	
	public VisiSchedauthMergeToSelect(DeciTreeOption<SchedauthInfo> option) {
		super(option, SchedauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchedauthInfo>> getActionClassHook() {
		return StdSchedauthDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedauthInfo> mergeHook(List<SchedauthInfo> baseInfos, List<SchedauthInfo> selectedInfos) {	
		return SchedauthMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
