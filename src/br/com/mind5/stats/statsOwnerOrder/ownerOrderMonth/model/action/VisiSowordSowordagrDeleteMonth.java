package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.decisionTree.RootSowordagrDeleteMonth;

final class VisiSowordSowordagrDeleteMonth extends ActionVisitorTemplateAction<SowordInfo, SowordagrInfo> {

	public VisiSowordSowordagrDeleteMonth(DeciTreeOption<SowordInfo> option) {
		super(option, SowordInfo.class, SowordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordagrInfo>> getTreeClassHook() {
		return RootSowordagrDeleteMonth.class;
	}
	
	
	
	@Override protected List<SowordInfo> toBaseClassHook(List<SowordInfo> baseInfos, List<SowordagrInfo> results) {
		return baseInfos;
	}
}
