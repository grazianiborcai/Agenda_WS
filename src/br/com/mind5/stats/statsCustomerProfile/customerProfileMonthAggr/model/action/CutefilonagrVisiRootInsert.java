package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.decisionTree.CutefilonagrRootInsert;

public final class CutefilonagrVisiRootInsert extends ActionVisitorTemplateAction<CutefilonagrInfo, CutefilonagrInfo> {

	public CutefilonagrVisiRootInsert(DeciTreeOption<CutefilonagrInfo> option) {
		super(option, CutefilonagrInfo.class, CutefilonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefilonagrInfo>> getTreeClassHook() {
		return CutefilonagrRootInsert.class;
	}
	
	
	
	@Override protected List<CutefilonagrInfo> toBaseClassHook(List<CutefilonagrInfo> baseInfos, List<CutefilonagrInfo> results) {
		return results;
	}
}
