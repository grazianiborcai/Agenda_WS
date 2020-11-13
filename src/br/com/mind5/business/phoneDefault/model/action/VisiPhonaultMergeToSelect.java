package br.com.mind5.business.phoneDefault.model.action;

import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.info.PhonaultMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonaultMergeToSelect extends ActionVisitorTemplateMerge<PhonaultInfo, PhonaultInfo> {
	
	public VisiPhonaultMergeToSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option, PhonaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhonaultInfo>> getActionClassHook() {
		return StdPhonaultDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonaultInfo> mergeHook(List<PhonaultInfo> baseInfos, List<PhonaultInfo> selectedInfos) {	
		return PhonaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
