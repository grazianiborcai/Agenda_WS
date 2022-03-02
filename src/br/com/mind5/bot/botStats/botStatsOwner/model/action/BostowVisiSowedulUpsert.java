package br.com.mind5.bot.botStats.botStatsOwner.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree.SowedulRootUpsert;

public final class BostowVisiSowedulUpsert extends ActionVisitorTemplateAction<BostowInfo, SowedulInfo> {

	public BostowVisiSowedulUpsert(DeciTreeOption<BostowInfo> option) {
		super(option, BostowInfo.class, SowedulInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedulInfo>> getTreeClassHook() {
		return SowedulRootUpsert.class;
	}
	
	
	
	@Override protected List<BostowInfo> toBaseClassHook(List<BostowInfo> baseInfos, List<SowedulInfo> results) {
		return baseInfos;
	}
}
