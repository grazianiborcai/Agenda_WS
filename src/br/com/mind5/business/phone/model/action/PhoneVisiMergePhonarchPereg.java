package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.PhonarchRootSelectPereg;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiMergePhonarchPereg extends ActionVisitorTemplateMerge<PhoneInfo, PhonarchInfo> {
	
	public PhoneVisiMergePhonarchPereg(DeciTreeOption<PhoneInfo> option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonarchInfo>> getTreeClassHook() {
		return PhonarchRootSelectPereg.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> baseInfos, List<PhonarchInfo> selectedInfos) {	
		return PhoneMerger.mergeWithPhonarchPereg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
