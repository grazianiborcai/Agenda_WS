package br.com.mind5.business.personSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.info.PersonapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonapMergeToSelect extends ActionVisitorTemplateMerge<PersonapInfo, PersonapInfo> {
	
	public VisiPersonapMergeToSelect(DeciTreeOption<PersonapInfo> option) {
		super(option, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PersonapInfo>> getActionClassHook() {
		return StdPersonapDaoSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> mergeHook(List<PersonapInfo> baseInfos, List<PersonapInfo> selectedInfos) {	
		return PersonapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
