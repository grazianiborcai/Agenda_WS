package br.com.mind5.bot.botStats.botStatsCustomer.model.action;

import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.decisionTree.CustamonRootUpsert;

public final class BostusVisiCustamonUpsert extends ActionVisitorTemplateAction<BostusInfo, CustamonInfo> {

	public BostusVisiCustamonUpsert(DeciTreeOption<BostusInfo> option) {
		super(option, BostusInfo.class, CustamonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustamonInfo>> getTreeClassHook() {
		return CustamonRootUpsert.class;
	}
	
	
	
	@Override protected List<BostusInfo> toBaseClassHook(List<BostusInfo> baseInfos, List<CustamonInfo> results) {
		return baseInfos;
	}
}
