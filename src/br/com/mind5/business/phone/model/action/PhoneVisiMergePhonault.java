package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.decisionTree.PhonaultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiMergePhonault extends ActionVisitorTemplateMerge<PhoneInfo, PhonaultInfo> {
	
	public PhoneVisiMergePhonault(DeciTreeOption<PhoneInfo> option) {
		super(option, PhonaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonaultInfo>> getTreeClassHook() {
		return PhonaultRootSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> baseInfos, List<PhonaultInfo> selectedInfos) {	
		return PhoneMerger.mergeWithPhonault(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
