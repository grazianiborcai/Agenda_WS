package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhoneMergeToDelete extends ActionVisitorTemplateMerge<PhoneInfo, PhoneInfo> {
	
	public VisiPhoneMergeToDelete(DeciTreeOption<PhoneInfo> option) {
		super(option, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhoneInfo>> getActionClassHook() {
		return StdPhoneDaoSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> baseInfos, List<PhoneInfo> selectedInfos) {	
		return PhoneMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
