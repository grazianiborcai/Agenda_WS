package br.com.mind5.bot.botStats.botStatsStore.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.decisionTree.RootSteddUpsertMonth;

final class VisiBostodSteddUpsertMonth extends ActionVisitorTemplateAction<BostodInfo, SteddInfo> {

	public VisiBostodSteddUpsertMonth(DeciTreeOption<BostodInfo> option) {
		super(option, BostodInfo.class, SteddInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddInfo>> getTreeClassHook() {
		return RootSteddUpsertMonth.class;
	}
	
	
	
	@Override protected List<BostodInfo> toBaseClassHook(List<BostodInfo> baseInfos, List<SteddInfo> results) {
		return baseInfos;
	}
}
