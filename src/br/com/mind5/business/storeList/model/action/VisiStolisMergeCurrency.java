package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.decisionTree.RootCurrencySelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolisMergeCurrency extends ActionVisitorTemplateMerge<StolisInfo, CurrencyInfo> {
	
	public VisiStolisMergeCurrency(DeciTreeOption<StolisInfo> option) {
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return RootCurrencySelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<CurrencyInfo> selectedInfos) {	
		return StolisMerger.mergeWithCurrency(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
