package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.decisionTree.SowordagrRootDelete;

public final class SowordagrVisiRootDelete extends ActionVisitorTemplateAction<SowordagrInfo, SowordagrInfo> {

	public SowordagrVisiRootDelete(DeciTreeOption<SowordagrInfo> option) {
		super(option, SowordagrInfo.class, SowordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordagrInfo>> getTreeClassHook() {
		return SowordagrRootDelete.class;
	}
	
	
	
	@Override protected List<SowordagrInfo> toBaseClassHook(List<SowordagrInfo> baseInfos, List<SowordagrInfo> results) {
		return results;
	}
}
