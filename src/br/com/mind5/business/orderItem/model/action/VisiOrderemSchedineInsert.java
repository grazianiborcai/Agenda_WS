package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.SchedineRootInsertFromOrderem;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemSchedineInsert extends ActionVisitorTemplateAction<OrderemInfo, SchedineInfo> {
	
	public VisiOrderemSchedineInsert(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedineInfo>> getTreeClassHook() {
		return SchedineRootInsertFromOrderem.class;
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<SchedineInfo> results) {
		return baseInfos;
	}
}
