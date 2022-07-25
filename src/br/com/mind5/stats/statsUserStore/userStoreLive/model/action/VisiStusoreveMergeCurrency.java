package br.com.mind5.stats.statsUserStore.userStoreLive.model.action;

import java.util.List;

import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.decisionTree.CurrencyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveInfo;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveMerger;

final class VisiStusoreveMergeCurrency extends ActionVisitorTemplateMerge<StusoreveInfo, CurrencyInfo> {
	
	public VisiStusoreveMergeCurrency(DeciTreeOption<StusoreveInfo> option) {
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return CurrencyRootSelect.class;
	}
	
	
	
	@Override protected List<StusoreveInfo> mergeHook(List<StusoreveInfo> baseInfos, List<CurrencyInfo> selectedInfos) {	
		return StusoreveMerger.mergeWithCurrency(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
