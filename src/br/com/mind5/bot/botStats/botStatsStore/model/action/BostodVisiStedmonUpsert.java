package br.com.mind5.bot.botStats.botStatsStore.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.decisionTree.StedmonRootUpsert;

public final class BostodVisiStedmonUpsert extends ActionVisitorTemplateAction<BostodInfo, StedmonInfo> {

	public BostodVisiStedmonUpsert(DeciTreeOption<BostodInfo> option) {
		super(option, BostodInfo.class, StedmonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StedmonInfo>> getTreeClassHook() {
		return StedmonRootUpsert.class;
	}
	
	
	
	@Override protected List<BostodInfo> toBaseClassHook(List<BostodInfo> baseInfos, List<StedmonInfo> results) {
		return baseInfos;
	}
}
