package br.com.mind5.business.employeeMaterialSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpmarchMergeToSelect extends ActionVisitorTemplateMerge<EmpmarchInfo, EmpmarchInfo> {
	
	public VisiEmpmarchMergeToSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option, EmpmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpmarchInfo>> getActionClassHook() {
		return StdEmpmarchDaoSelect.class;
	}
	
	
	
	@Override protected List<EmpmarchInfo> mergeHook(List<EmpmarchInfo> baseInfos, List<EmpmarchInfo> selectedInfos) {	
		return EmpmarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
