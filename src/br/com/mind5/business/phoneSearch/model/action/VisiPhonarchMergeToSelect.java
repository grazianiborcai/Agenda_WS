package br.com.mind5.business.phoneSearch.model.action;

import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonarchMergeToSelect extends ActionVisitorTemplateMerge<PhonarchInfo, PhonarchInfo> {
	
	public VisiPhonarchMergeToSelect(DeciTreeOption<PhonarchInfo> option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhonarchInfo>> getActionClassHook() {
		return StdPhonarchDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonarchInfo> mergeHook(List<PhonarchInfo> baseInfos, List<PhonarchInfo> selectedInfos) {	
		return PhonarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
