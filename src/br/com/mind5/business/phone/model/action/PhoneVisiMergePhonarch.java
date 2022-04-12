package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.PhonarchRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiMergePhonarch extends ActionVisitorTemplateMerge<PhoneInfo, PhonarchInfo> {
	
	public PhoneVisiMergePhonarch(DeciTreeOption<PhoneInfo> option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonarchInfo>> getTreeClassHook() {
		return PhonarchRootSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> baseInfos, List<PhonarchInfo> selectedInfos) {	
		return PhoneMerger.mergeWithPhonarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
