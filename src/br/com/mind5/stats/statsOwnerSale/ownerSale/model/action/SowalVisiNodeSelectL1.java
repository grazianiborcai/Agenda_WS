package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree.SowalNodeSelectL1;

public final class SowalVisiNodeSelectL1 extends ActionVisitorTemplateAction<SowalInfo, SowalInfo> {

	public SowalVisiNodeSelectL1(DeciTreeOption<SowalInfo> option) {
		super(option, SowalInfo.class, SowalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowalInfo>> getTreeClassHook() {
		return SowalNodeSelectL1.class;
	}
	
	
	
	@Override protected List<SowalInfo> toBaseClassHook(List<SowalInfo> baseInfos, List<SowalInfo> results) {
		return results;
	}
}
