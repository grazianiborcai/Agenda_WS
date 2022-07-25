package br.com.mind5.stats.statsUserStore.userStoreAggr.model.action;

import java.util.List;

import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.decisionTree.CurrencyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggMerger;

public final class StusoraggVisiMergeCurrency extends ActionVisitorTemplateMerge<StusoraggInfo, CurrencyInfo> {
	
	public StusoraggVisiMergeCurrency(DeciTreeOption<StusoraggInfo> option) {
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return CurrencyRootSelect.class;
	}
	
	
	
	@Override protected List<StusoraggInfo> mergeHook(List<StusoraggInfo> baseInfos, List<CurrencyInfo> selectedInfos) {	
		return StusoraggMerger.mergeWithCurrency(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
