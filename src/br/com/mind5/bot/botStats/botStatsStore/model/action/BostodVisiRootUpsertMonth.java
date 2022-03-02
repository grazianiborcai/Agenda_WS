package br.com.mind5.bot.botStats.botStatsStore.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStore.model.decisionTree.BostodRootUpsertMonth;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostodVisiRootUpsertMonth extends ActionVisitorTemplateAction<BostodInfo, BostodInfo> {

	public BostodVisiRootUpsertMonth(DeciTreeOption<BostodInfo> option) {
		super(option, BostodInfo.class, BostodInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BostodInfo>> getTreeClassHook() {
		return BostodRootUpsertMonth.class;
	}
	
	
	
	@Override protected List<BostodInfo> toBaseClassHook(List<BostodInfo> baseInfos, List<BostodInfo> results) {
		return results;
	}
}
