package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree.RootStoronUpsert;

public final class BostodVisiStoronUpsert extends ActionVisitorTemplateAction<BostusInfo, StoronInfo> {

	public BostodVisiStoronUpsert(DeciTreeOption<BostusInfo> option) {
		super(option, BostusInfo.class, StoronInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoronInfo>> getTreeClassHook() {
		return RootStoronUpsert.class;
	}
	
	
	
	@Override protected List<BostusInfo> toBaseClassHook(List<BostusInfo> baseInfos, List<StoronInfo> results) {
		return baseInfos;
	}
}
