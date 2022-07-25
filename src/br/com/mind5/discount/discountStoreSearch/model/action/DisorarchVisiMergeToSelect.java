package br.com.mind5.discount.discountStoreSearch.model.action;

import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorarchVisiMergeToSelect extends ActionVisitorTemplateMerge<DisorarchInfo, DisorarchInfo> {
	
	public DisorarchVisiMergeToSelect(DeciTreeOption<DisorarchInfo> option) {
		super(option, DisorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<DisorarchInfo>> getVisitorClassHook() {
		return DisorarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<DisorarchInfo> mergeHook(List<DisorarchInfo> baseInfos, List<DisorarchInfo> selectedInfos) {	
		return DisorarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
