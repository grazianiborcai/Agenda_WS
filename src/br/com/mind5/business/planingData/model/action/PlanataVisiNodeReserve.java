package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.decisionTree.PlanataNodeReserve;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataVisiNodeReserve extends ActionVisitorTemplateAction<PlanataInfo, PlanataInfo> {

	public PlanataVisiNodeReserve(DeciTreeOption<PlanataInfo> option) {
		super(option, PlanataInfo.class, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PlanataInfo>> getTreeClassHook() {
		return PlanataNodeReserve.class;
	}
	
	
	
	@Override protected List<PlanataInfo> toBaseClassHook(List<PlanataInfo> baseInfos, List<PlanataInfo> results) {
		return results;
	}
}
