package br.com.mind5.business.customerList.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.info.CuslisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCuslisMergeToSelect extends ActionVisitorTemplateMerge<CuslisInfo, CuslisInfo> {
	
	public VisiCuslisMergeToSelect(DeciTreeOption<CuslisInfo> option) {
		super(option, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CuslisInfo>> getActionClassHook() {
		return StdCuslisDaoSelect.class;
	}
	
	
	
	@Override protected List<CuslisInfo> mergeHook(List<CuslisInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return CuslisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
