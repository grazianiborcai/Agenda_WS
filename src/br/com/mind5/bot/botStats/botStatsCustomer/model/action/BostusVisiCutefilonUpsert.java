package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.decisionTree.CutefilonRootUpsert;

public final class BostusVisiCutefilonUpsert extends ActionVisitorTemplateAction<BostusInfo, CutefilonInfo> {

	public BostusVisiCutefilonUpsert(DeciTreeOption<BostusInfo> option) {
		super(option, BostusInfo.class, CutefilonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefilonInfo>> getTreeClassHook() {
		return CutefilonRootUpsert.class;
	}
	
	
	
	@Override protected List<BostusInfo> toBaseClassHook(List<BostusInfo> baseInfos, List<CutefilonInfo> results) {
		return baseInfos;
	}
}
