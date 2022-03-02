package br.com.mind5.bot.botStats.botStatsOwner.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree.SowalRootUpsert;

public final class BostowVisiSowalUpsert extends ActionVisitorTemplateAction<BostowInfo, SowalInfo> {

	public BostowVisiSowalUpsert(DeciTreeOption<BostowInfo> option) {
		super(option, BostowInfo.class, SowalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowalInfo>> getTreeClassHook() {
		return SowalRootUpsert.class;
	}
	
	
	
	@Override protected List<BostowInfo> toBaseClassHook(List<BostowInfo> baseInfos, List<SowalInfo> results) {
		return baseInfos;
	}
}
