package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.userOrderYearStgn.model.decisionTree.RootStusorygeUpsertOrderem;

final class VisiOrderemStusorygeUpsert extends ActionVisitorTemplateAction<OrderemInfo, StusorygeInfo> {
	
	public VisiOrderemStusorygeUpsert(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, StusorygeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorygeInfo>> getTreeClassHook() {
		return RootStusorygeUpsertOrderem.class;
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<StusorygeInfo> results) {
		return baseInfos;
	}
}
