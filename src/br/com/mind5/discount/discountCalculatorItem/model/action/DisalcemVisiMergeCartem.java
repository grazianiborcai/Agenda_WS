package br.com.mind5.discount.discountCalculatorItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.CartemRootSearchUser;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisalcemVisiMergeCartem extends ActionVisitorTemplateMerge<DisalcemInfo, CartemInfo> {
	
	public DisalcemVisiMergeCartem(DeciTreeOption<DisalcemInfo> option) {
		super(option, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemInfo>> getTreeClassHook() {
		return CartemRootSearchUser.class;
	}
	
	
	
	@Override protected List<DisalcemInfo> mergeHook(List<DisalcemInfo> baseInfos, List<CartemInfo> selectedInfos) {	
		return DisalcemMerger.mergeWithCartem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
