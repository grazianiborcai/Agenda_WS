package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree.SowordNodeUpsertL2;

public final class SowordVisiNodeUpsertL2 extends ActionVisitorTemplateAction<SowordInfo, SowordInfo> {

	public SowordVisiNodeUpsertL2(DeciTreeOption<SowordInfo> option) {
		super(option, SowordInfo.class, SowordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowordInfo>> getTreeClassHook() {
		return SowordNodeUpsertL2.class;
	}
	
	
	
	@Override protected List<SowordInfo> toBaseClassHook(List<SowordInfo> baseInfos, List<SowordInfo> results) {
		return results;
	}
}
