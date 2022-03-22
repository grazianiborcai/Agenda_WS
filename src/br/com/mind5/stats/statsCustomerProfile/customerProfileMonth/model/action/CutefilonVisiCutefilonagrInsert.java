package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonMerger;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.decisionTree.CutefilonagrRootInsert;

public final class CutefilonVisiCutefilonagrInsert extends ActionVisitorTemplateAction<CutefilonInfo, CutefilonagrInfo> {

	public CutefilonVisiCutefilonagrInsert(DeciTreeOption<CutefilonInfo> option) {
		super(option, CutefilonInfo.class, CutefilonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefilonagrInfo>> getTreeClassHook() {
		return CutefilonagrRootInsert.class;
	}
	
	
	
	@Override protected List<CutefilonInfo> toBaseClassHook(List<CutefilonInfo> baseInfos, List<CutefilonagrInfo> results) {
		return CutefilonMerger.mergeWithCutefilonagr(baseInfos, results);
	}
}
