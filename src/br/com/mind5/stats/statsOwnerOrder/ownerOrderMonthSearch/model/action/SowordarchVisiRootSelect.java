package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.decisionTree.SowordarchRootSelect;

public final class SowordarchVisiRootSelect extends ActionVisitorTemplateAction<SowordarchInfo, SowordarchInfo> {

	public SowordarchVisiRootSelect(DeciTreeOption<SowordarchInfo> option) {
		super(option, SowordarchInfo.class, SowordarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordarchInfo>> getTreeClassHook() {
		return SowordarchRootSelect.class;
	}
	
	
	
	@Override protected List<SowordarchInfo> toBaseClassHook(List<SowordarchInfo> baseInfos, List<SowordarchInfo> results) {
		return results;
	}
}
