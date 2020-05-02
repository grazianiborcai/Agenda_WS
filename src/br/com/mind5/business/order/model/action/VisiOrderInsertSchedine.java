package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.RootSchedineFromOrder;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderInsertSchedine extends ActionVisitorTemplateActionV2<OrderInfo, SchedineInfo> {
	
	public VisiOrderInsertSchedine(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedineInfo>> getTreeClassHook() {
		return RootSchedineFromOrder.class;
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<SchedineInfo> results) {
		return baseInfos;
	}
}
