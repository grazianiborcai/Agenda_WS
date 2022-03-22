package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree.RootStordUpsertMonth;

public final class BostodVisiStordUpsertMonth extends ActionVisitorTemplateAction<BostusInfo, StordInfo> {

	public BostodVisiStordUpsertMonth(DeciTreeOption<BostusInfo> option) {
		super(option, BostusInfo.class, StordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordInfo>> getTreeClassHook() {
		return RootStordUpsertMonth.class;
	}
	
	
	
	@Override protected List<BostusInfo> toBaseClassHook(List<BostusInfo> baseInfos, List<StordInfo> results) {
		return baseInfos;
	}
}
