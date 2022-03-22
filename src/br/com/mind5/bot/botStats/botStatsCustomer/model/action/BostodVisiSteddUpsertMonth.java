package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.decisionTree.SteddRootUpsertMonth;

public final class BostodVisiSteddUpsertMonth extends ActionVisitorTemplateAction<BostusInfo, SteddInfo> {

	public BostodVisiSteddUpsertMonth(DeciTreeOption<BostusInfo> option) {
		super(option, BostusInfo.class, SteddInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddInfo>> getTreeClassHook() {
		return SteddRootUpsertMonth.class;
	}
	
	
	
	@Override protected List<BostusInfo> toBaseClassHook(List<BostusInfo> baseInfos, List<SteddInfo> results) {
		return baseInfos;
	}
}
