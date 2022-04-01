package br.com.mind5.business.company.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompVisiMergeToDelete extends ActionVisitorTemplateMerge<CompInfo, CompInfo> {
	
	public CompVisiMergeToDelete(DeciTreeOption<CompInfo> option) {
		super(option, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CompInfo>> getVisitorClassHook() {
		return CompVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CompInfo> mergeHook(List<CompInfo> baseInfos, List<CompInfo> selectedInfos) {	
		return CompMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
