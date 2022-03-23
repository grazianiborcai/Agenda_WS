package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.scheduleLine.info.SchedineCopier;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.SchedineRootRefresh;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemSchedineRefresh extends ActionVisitorTemplateAction<OrderemInfo, SchedineInfo> {
	
	public VisiOrderemSchedineRefresh(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedineInfo>> getTreeClassHook() {
		return SchedineRootRefresh.class;
	}
	
	
	
	@Override protected List<SchedineInfo> toActionClassHook(List<OrderemInfo> baseInfos) {
		return SchedineCopier.copyFromOrderem(baseInfos);
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<SchedineInfo> results) {
		return baseInfos;
	}
}
