package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.PhonarchRootSelectStore;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiMergePhonarchStore extends ActionVisitorTemplateMerge<PhoneInfo, PhonarchInfo> {
	
	public PhoneVisiMergePhonarchStore(DeciTreeOption<PhoneInfo> option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonarchInfo>> getTreeClassHook() {
		return PhonarchRootSelectStore.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> baseInfos, List<PhonarchInfo> selectedInfos) {	
		return PhoneMerger.mergeWithPhonarchStore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
