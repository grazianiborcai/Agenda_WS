package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

public final class RefupownVisiMergeUsername extends ActionVisitorTemplateMerge<RefupownInfo, UsernameInfo> {
	
	public RefupownVisiMergeUsername(DeciTreeOption<RefupownInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<RefupownInfo> baseInfos) {
		return UsernameCopier.copyFromRefupown(baseInfos);	
	}
	
	
	
	@Override protected List<RefupownInfo> mergeHook(List<RefupownInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		return RefupownMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
