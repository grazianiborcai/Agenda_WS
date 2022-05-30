package br.com.mind5.authorization.scheduleAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class VisiSchedauthMergeUsername extends ActionVisitorTemplateMerge<SchedauthInfo, UsernameInfo> {
	
	public VisiSchedauthMergeUsername(DeciTreeOption<SchedauthInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<SchedauthInfo> mergeHook(List<SchedauthInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return SchedauthMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
