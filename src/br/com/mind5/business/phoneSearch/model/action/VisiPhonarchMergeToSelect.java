package br.com.mind5.business.phoneSearch.model.action;

import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonarchMergeToSelect extends ActionVisitorTemplateMergeV2<PhonarchInfo, PhonarchInfo> {
	
	public VisiPhonarchMergeToSelect(DeciTreeOption<PhonarchInfo> option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PhonarchInfo>> getActionClassHook() {
		return StdPhonarchDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonarchInfo> mergeHook(List<PhonarchInfo> baseInfos, List<PhonarchInfo> selectedInfos) {	
		return PhonarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
