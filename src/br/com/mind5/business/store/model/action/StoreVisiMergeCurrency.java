package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.decisionTree.CurrencyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMergeCurrency extends ActionVisitorTemplateMerge<StoreInfo, CurrencyInfo> {
	
	public StoreVisiMergeCurrency(DeciTreeOption<StoreInfo> option) {
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return CurrencyRootSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<CurrencyInfo> selectedInfos) {	
		return StoreMerger.mergeWithCurrency(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
