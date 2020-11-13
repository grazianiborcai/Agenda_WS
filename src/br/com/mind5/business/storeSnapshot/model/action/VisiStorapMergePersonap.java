package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapCopier;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.RootPersonapSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorapMergePersonap extends ActionVisitorTemplateMerge<StorapInfo, PersonapInfo> {
	
	public VisiStorapMergePersonap(DeciTreeOption<StorapInfo> option) {
		super(option, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return RootPersonapSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> toActionClassHook(List<StorapInfo> baseInfos) {
		return PersonapCopier.copyFromStorap(baseInfos);
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<PersonapInfo> selectedInfos) {	
		return StorapMerger.mergeWithPersonap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}	
}
