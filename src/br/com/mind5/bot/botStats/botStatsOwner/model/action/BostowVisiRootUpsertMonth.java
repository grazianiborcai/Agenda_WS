package br.com.mind5.bot.botStats.botStatsOwner.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.bot.botStats.botStatsOwner.model.decisionTree.BostowRootUpsertMonth;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostowVisiRootUpsertMonth extends ActionVisitorTemplateAction<BostowInfo, BostowInfo> {

	public BostowVisiRootUpsertMonth(DeciTreeOption<BostowInfo> option) {
		super(option, BostowInfo.class, BostowInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BostowInfo>> getTreeClassHook() {
		return BostowRootUpsertMonth.class;
	}
	
	
	
	@Override protected List<BostowInfo> toBaseClassHook(List<BostowInfo> baseInfos, List<BostowInfo> results) {
		return results;
	}
}
