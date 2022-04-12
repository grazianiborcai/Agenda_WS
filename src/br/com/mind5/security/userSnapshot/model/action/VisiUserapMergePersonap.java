package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapCopier;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.PersonapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapMerger;

final class VisiUserapMergePersonap extends ActionVisitorTemplateMerge<UserapInfo, PersonapInfo> {
	
	public VisiUserapMergePersonap(DeciTreeOption<UserapInfo> option) {
		super(option, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return PersonapRootSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> toActionClassHook(List<UserapInfo> baseInfos) {
		return PersonapCopier.copyFromUserapKey(baseInfos);
	}	
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> baseInfos, List<PersonapInfo> selectedInfos) {	
		return UserapMerger.mergeWithPersonap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
