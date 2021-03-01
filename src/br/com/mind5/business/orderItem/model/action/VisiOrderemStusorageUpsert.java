package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.decisionTree.RootStusorageUpsertOrderem;

final class VisiOrderemStusorageUpsert extends ActionVisitorTemplateAction<OrderemInfo, StusorageInfo> {
	
	public VisiOrderemStusorageUpsert(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, StusorageInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorageInfo>> getTreeClassHook() {
		return RootStusorageUpsertOrderem.class;
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<StusorageInfo> results) {
		return baseInfos;
	}
}
