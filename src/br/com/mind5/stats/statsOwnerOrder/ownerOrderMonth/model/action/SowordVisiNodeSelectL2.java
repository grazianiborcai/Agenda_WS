package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree.SowordNodeSelectL2;

public final class SowordVisiNodeSelectL2 extends ActionVisitorTemplateAction<SowordInfo, SowordInfo> {

	public SowordVisiNodeSelectL2(DeciTreeOption<SowordInfo> option) {
		super(option, SowordInfo.class, SowordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordInfo>> getTreeClassHook() {
		return SowordNodeSelectL2.class;
	}
	
	
	
	@Override protected List<SowordInfo> toBaseClassHook(List<SowordInfo> baseInfos, List<SowordInfo> results) {
		return results;
	}
}
