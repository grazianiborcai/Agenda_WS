package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.model.decisionTree.BostusRootUpsertMonth;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostusVisiRootUpsertMonth extends ActionVisitorTemplateAction<BostusInfo, BostusInfo> {

	public BostusVisiRootUpsertMonth(DeciTreeOption<BostusInfo> option) {
		super(option, BostusInfo.class, BostusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BostusInfo>> getTreeClassHook() {
		return BostusRootUpsertMonth.class;
	}
	
	
	
	@Override protected List<BostusInfo> toBaseClassHook(List<BostusInfo> baseInfos, List<BostusInfo> results) {
		return results;
	}
}
