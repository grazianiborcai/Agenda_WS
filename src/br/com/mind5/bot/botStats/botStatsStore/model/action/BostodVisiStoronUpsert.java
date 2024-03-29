package br.com.mind5.bot.botStats.botStatsStore.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree.StoronRootUpsert;

public final class BostodVisiStoronUpsert extends ActionVisitorTemplateAction<BostodInfo, StoronInfo> {

	public BostodVisiStoronUpsert(DeciTreeOption<BostodInfo> option) {
		super(option, BostodInfo.class, StoronInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoronInfo>> getTreeClassHook() {
		return StoronRootUpsert.class;
	}
	
	
	
	@Override protected List<BostodInfo> toBaseClassHook(List<BostodInfo> baseInfos, List<StoronInfo> results) {
		return baseInfos;
	}
}
