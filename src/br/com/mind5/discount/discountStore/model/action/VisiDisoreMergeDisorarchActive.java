package br.com.mind5.discount.discountStore.model.action;

import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.info.DisoreMerger;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.model.decisionTree.RootDisorarchSelectActive;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoreMergeDisorarchActive extends ActionVisitorTemplateMerge<DisoreInfo, DisorarchInfo> {
	
	public VisiDisoreMergeDisorarchActive(DeciTreeOption<DisoreInfo> option) {
		super(option, DisorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisorarchInfo>> getTreeClassHook() {
		return RootDisorarchSelectActive.class;
	}
	
	
	
	@Override protected List<DisoreInfo> mergeHook(List<DisoreInfo> baseInfos, List<DisorarchInfo> selectedInfos) {	
		return DisoreMerger.mergeWithDisorarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
