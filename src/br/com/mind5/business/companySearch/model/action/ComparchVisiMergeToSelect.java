package br.com.mind5.business.companySearch.model.action;

import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.info.ComparchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ComparchVisiMergeToSelect extends ActionVisitorTemplateMerge<ComparchInfo, ComparchInfo> {
	
	public ComparchVisiMergeToSelect(DeciTreeOption<ComparchInfo> option) {
		super(option, ComparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<ComparchInfo>> getVisitorClassHook() {
		return ComparchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<ComparchInfo> mergeHook(List<ComparchInfo> baseInfos, List<ComparchInfo> selectedInfos) {	
		return ComparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
