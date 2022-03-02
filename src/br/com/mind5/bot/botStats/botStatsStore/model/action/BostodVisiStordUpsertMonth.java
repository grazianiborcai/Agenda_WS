package br.com.mind5.bot.botStats.botStatsStore.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree.RootStordUpsertMonth;

public final class BostodVisiStordUpsertMonth extends ActionVisitorTemplateAction<BostodInfo, StordInfo> {

	public BostodVisiStordUpsertMonth(DeciTreeOption<BostodInfo> option) {
		super(option, BostodInfo.class, StordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordInfo>> getTreeClassHook() {
		return RootStordUpsertMonth.class;
	}
	
	
	
	@Override protected List<BostodInfo> toBaseClassHook(List<BostodInfo> baseInfos, List<StordInfo> results) {
		return baseInfos;
	}
}
