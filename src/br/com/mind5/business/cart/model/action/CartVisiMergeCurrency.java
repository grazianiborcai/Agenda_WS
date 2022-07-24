package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.decisionTree.CurrencyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartVisiMergeCurrency extends ActionVisitorTemplateMerge<CartInfo, CurrencyInfo> {
	
	public CartVisiMergeCurrency(DeciTreeOption<CartInfo> option) {
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return CurrencyRootSelect.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> baseInfos, List<CurrencyInfo> selectedInfos) {	
		return CartMerger.mergeWithCurrency(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
