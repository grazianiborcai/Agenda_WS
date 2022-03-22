package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.model.decisionTree.BostodRootUpsertMonth;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostodVisiRootUpsertMonth extends ActionVisitorTemplateAction<BostusInfo, BostusInfo> {

	public BostodVisiRootUpsertMonth(DeciTreeOption<BostusInfo> option) {
		super(option, BostusInfo.class, BostusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BostusInfo>> getTreeClassHook() {
		return BostodRootUpsertMonth.class;
	}
	
	
	
	@Override protected List<BostusInfo> toBaseClassHook(List<BostusInfo> baseInfos, List<BostusInfo> results) {
		return results;
	}
}
