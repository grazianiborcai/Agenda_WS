package br.com.mind5.discount.discountStore.model.action;

import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.info.DisoreMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoreMergeToSelect extends ActionVisitorTemplateMerge<DisoreInfo, DisoreInfo> {
	
	public VisiDisoreMergeToSelect(DeciTreeOption<DisoreInfo> option) {
		super(option, DisoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<DisoreInfo>> getActionClassHook() {
		return StdDisoreDaoSelect.class;
	}
	
	
	
	@Override protected List<DisoreInfo> mergeHook(List<DisoreInfo> baseInfos, List<DisoreInfo> selectedInfos) {	
		return DisoreMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
