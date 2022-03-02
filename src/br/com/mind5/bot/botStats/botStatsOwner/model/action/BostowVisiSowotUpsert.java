package br.com.mind5.bot.botStats.botStatsOwner.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.decisionTree.SowotRootUpsert;

public final class BostowVisiSowotUpsert extends ActionVisitorTemplateAction<BostowInfo, SowotInfo> {

	public BostowVisiSowotUpsert(DeciTreeOption<BostowInfo> option) {
		super(option, BostowInfo.class, SowotInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotInfo>> getTreeClassHook() {
		return SowotRootUpsert.class;
	}
	
	
	
	@Override protected List<BostowInfo> toBaseClassHook(List<BostowInfo> baseInfos, List<SowotInfo> results) {
		return baseInfos;
	}
}
