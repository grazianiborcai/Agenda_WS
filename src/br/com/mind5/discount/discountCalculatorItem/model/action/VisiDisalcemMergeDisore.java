package br.com.mind5.discount.discountCalculatorItem.model.action;

import java.util.List;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemMerger;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.decisionTree.DisoreRootSelectActive;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisalcemMergeDisore extends ActionVisitorTemplateMerge<DisalcemInfo, DisoreInfo> {
	
	public VisiDisalcemMergeDisore(DeciTreeOption<DisalcemInfo> option) {
		super(option, DisoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DisoreInfo>> getTreeClassHook() {
		return DisoreRootSelectActive.class;
	}
	
	
	
	@Override protected List<DisalcemInfo> mergeHook(List<DisalcemInfo> baseInfos, List<DisoreInfo> selectedInfos) {	
		return DisalcemMerger.mergeWithDisore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
