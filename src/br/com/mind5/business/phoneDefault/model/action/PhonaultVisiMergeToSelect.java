package br.com.mind5.business.phoneDefault.model.action;

import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.info.PhonaultMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonaultVisiMergeToSelect extends ActionVisitorTemplateMerge<PhonaultInfo, PhonaultInfo> {
	
	public PhonaultVisiMergeToSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option, PhonaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PhonaultInfo>> getVisitorClassHook() {
		return PhonaultVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonaultInfo> mergeHook(List<PhonaultInfo> baseInfos, List<PhonaultInfo> selectedInfos) {	
		return PhonaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
