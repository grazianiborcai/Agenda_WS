package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.decisionTree.CurrencyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiMergeCurrency extends ActionVisitorTemplateMerge<OrderInfo, CurrencyInfo> {
	
	public OrderVisiMergeCurrency(DeciTreeOption<OrderInfo> option) { 
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return CurrencyRootSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<CurrencyInfo> selectedInfos) {	
		return OrderMerger.mergeWithCurrency(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
