package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataVisiMergeToSelect extends ActionVisitorTemplateMerge<PlanataInfo, PlanataInfo> {
	
	public PlanataVisiMergeToSelect(DeciTreeOption<PlanataInfo> option) {
		super(option, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PlanataInfo>> getVisitorClassHook() {
		return PlanataVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> mergeHook(List<PlanataInfo> baseInfos, List<PlanataInfo> selectedInfos) {	
		return PlanataMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
