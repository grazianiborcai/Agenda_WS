package br.com.mind5.business.phoneDefault.model.action;

import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.info.PhonaultMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonaultMergeToSelect extends ActionVisitorTemplateMergeV2<PhonaultInfo, PhonaultInfo> {
	
	public VisiPhonaultMergeToSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option, PhonaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PhonaultInfo>> getActionClassHook() {
		return StdPhonaultDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonaultInfo> mergeHook(List<PhonaultInfo> baseInfos, List<PhonaultInfo> selectedInfos) {	
		return PhonaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
