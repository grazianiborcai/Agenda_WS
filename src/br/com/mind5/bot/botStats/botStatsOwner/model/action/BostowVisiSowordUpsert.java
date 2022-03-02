package br.com.mind5.bot.botStats.botStatsOwner.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree.SowordRootUpsert;

public final class BostowVisiSowordUpsert extends ActionVisitorTemplateAction<BostowInfo, SowordInfo> {

	public BostowVisiSowordUpsert(DeciTreeOption<BostowInfo> option) {
		super(option, BostowInfo.class, SowordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordInfo>> getTreeClassHook() {
		return SowordRootUpsert.class;
	}
	
	
	
	@Override protected List<BostowInfo> toBaseClassHook(List<BostowInfo> baseInfos, List<SowordInfo> results) {
		return baseInfos;
	}
}
