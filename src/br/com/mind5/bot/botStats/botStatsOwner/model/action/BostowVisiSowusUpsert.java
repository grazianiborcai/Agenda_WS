package br.com.mind5.bot.botStats.botStatsOwner.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree.SowusRootUpsert;

public final class BostowVisiSowusUpsert extends ActionVisitorTemplateAction<BostowInfo, SowusInfo> {

	public BostowVisiSowusUpsert(DeciTreeOption<BostowInfo> option) {
		super(option, BostowInfo.class, SowusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusInfo>> getTreeClassHook() {
		return SowusRootUpsert.class;
	}
	
	
	
	@Override protected List<BostowInfo> toBaseClassHook(List<BostowInfo> baseInfos, List<SowusInfo> results) {
		return baseInfos;
	}
}
