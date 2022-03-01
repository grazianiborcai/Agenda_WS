package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree.SowalNodeUpsertL2;

public final class SowalVisiNodeUpsertL2 extends ActionVisitorTemplateAction<SowalInfo, SowalInfo> {

	public SowalVisiNodeUpsertL2(DeciTreeOption<SowalInfo> option) {
		super(option, SowalInfo.class, SowalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowalInfo>> getTreeClassHook() {
		return SowalNodeUpsertL2.class;
	}
	
	
	
	@Override protected List<SowalInfo> toBaseClassHook(List<SowalInfo> baseInfos, List<SowalInfo> results) {
		return results;
	}
}
