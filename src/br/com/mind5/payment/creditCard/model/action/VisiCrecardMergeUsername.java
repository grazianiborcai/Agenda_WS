package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

final class VisiCrecardMergeUsername extends ActionVisitorTemplateMerge<CrecardInfo, UsernameInfo> {
	
	public VisiCrecardMergeUsername(DeciTreeOption<CrecardInfo> option) {
		super(option, UsernameInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return UsernameCopier.copyFromCrecard(baseInfos);	
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return CrecardMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
