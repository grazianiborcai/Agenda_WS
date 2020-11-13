package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusMergeToUpdate extends ActionVisitorTemplateMerge<CusInfo, CusInfo> {
	
	public VisiCusMergeToUpdate(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CusInfo>> getActionClassHook() {
		return StdCusDaoSelect.class;
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<CusInfo> selectedInfos) {	
		return CusMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
