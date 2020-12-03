package br.com.mind5.discount.discountStoreSearch.model.action;

import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisorarchMergeToSelect extends ActionVisitorTemplateMerge<DisorarchInfo, DisorarchInfo> {
	
	public VisiDisorarchMergeToSelect(DeciTreeOption<DisorarchInfo> option) {
		super(option, DisorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<DisorarchInfo>> getActionClassHook() {
		return StdDisorarchDaoSelect.class;
	}
	
	
	
	@Override protected List<DisorarchInfo> mergeHook(List<DisorarchInfo> baseInfos, List<DisorarchInfo> selectedInfos) {	
		return DisorarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
