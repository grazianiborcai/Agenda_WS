package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.business.materialPrice.model.decisionTree.RootMaticeSelectByDate;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataVisiMergeMatice extends ActionVisitorTemplateMerge<PlanataInfo, MaticeInfo> {
	
	public PlanataVisiMergeMatice(DeciTreeOption<PlanataInfo> option) {
		super(option, MaticeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MaticeInfo>> getTreeClassHook() {
		return RootMaticeSelectByDate.class;
	}
	
	
	
	@Override protected List<PlanataInfo> mergeHook(List<PlanataInfo> baseInfos, List<MaticeInfo> selectedInfos) {	
		return PlanataMerger.mergeWithMatice(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
