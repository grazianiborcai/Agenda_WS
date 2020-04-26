package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.model.decisionTree.RootFeewnerSelectService;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartMergeFeewner extends ActionVisitorTemplateMergeV2<CartInfo, FeewnerInfo> {
	
	public VisiCartMergeFeewner(DeciTreeOption<CartInfo> option) {
		super(option, FeewnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeewnerInfo>> getTreeClassHook() {
		return RootFeewnerSelectService.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> baseInfos, List<FeewnerInfo> selectedInfos) {	
		return CartMerger.mergeWithFeewner(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
