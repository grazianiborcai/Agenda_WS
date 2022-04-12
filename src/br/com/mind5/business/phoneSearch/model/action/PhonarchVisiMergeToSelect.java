package br.com.mind5.business.phoneSearch.model.action;

import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonarchVisiMergeToSelect extends ActionVisitorTemplateMerge<PhonarchInfo, PhonarchInfo> {
	
	public PhonarchVisiMergeToSelect(DeciTreeOption<PhonarchInfo> option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PhonarchInfo>> getVisitorClassHook() {
		return PhonarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonarchInfo> mergeHook(List<PhonarchInfo> baseInfos, List<PhonarchInfo> selectedInfos) {	
		return PhonarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
