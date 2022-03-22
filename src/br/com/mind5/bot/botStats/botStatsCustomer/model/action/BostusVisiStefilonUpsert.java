package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.decisionTree.StefilonRootUpsert;

public final class BostusVisiStefilonUpsert extends ActionVisitorTemplateAction<BostusInfo, StefilonInfo> {

	public BostusVisiStefilonUpsert(DeciTreeOption<BostusInfo> option) {
		super(option, BostusInfo.class, StefilonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefilonInfo>> getTreeClassHook() {
		return StefilonRootUpsert.class;
	}
	
	
	
	@Override protected List<BostusInfo> toBaseClassHook(List<BostusInfo> baseInfos, List<StefilonInfo> results) {
		return baseInfos;
	}
}
