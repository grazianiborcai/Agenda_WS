package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.decisionTree.CurrencyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorapVisiMergeCurrency extends ActionVisitorTemplateMerge<StorapInfo, CurrencyInfo> {
	
	public StorapVisiMergeCurrency(DeciTreeOption<StorapInfo> option) {
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return CurrencyRootSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<CurrencyInfo> selectedInfos) {	
		return StorapMerger.mergeWithCurrency(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
