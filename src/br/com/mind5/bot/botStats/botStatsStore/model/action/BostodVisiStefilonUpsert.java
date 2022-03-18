package br.com.mind5.bot.botStats.botStatsStore.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.decisionTree.StefilonRootUpsert;

public final class BostodVisiStefilonUpsert extends ActionVisitorTemplateAction<BostodInfo, StefilonInfo> {

	public BostodVisiStefilonUpsert(DeciTreeOption<BostodInfo> option) {
		super(option, BostodInfo.class, StefilonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefilonInfo>> getTreeClassHook() {
		return StefilonRootUpsert.class;
	}
	
	
	
	@Override protected List<BostodInfo> toBaseClassHook(List<BostodInfo> baseInfos, List<StefilonInfo> results) {
		return baseInfos;
	}
}
