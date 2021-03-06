package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.RootMatlisSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanataMergeMatlis extends ActionVisitorTemplateMerge<PlanataInfo, MatlisInfo> {
	
	public VisiPlanataMergeMatlis(DeciTreeOption<PlanataInfo> option) {
		super(option, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return RootMatlisSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> mergeHook(List<PlanataInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return PlanataMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
