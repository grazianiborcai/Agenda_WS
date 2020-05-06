package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartMergeToSelect extends ActionVisitorTemplateMergeV2<CartInfo, CartInfo> {
	
	public VisiCartMergeToSelect(DeciTreeOption<CartInfo> option) {
		super(option, CartInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CartInfo>> getActionClassHook() {
		return StdCartDaoSelect.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> baseInfos, List<CartInfo> selectedInfos) {	
		return CartMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
