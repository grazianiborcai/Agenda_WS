package br.com.mind5.business.customerSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusarchMergeToSelect extends ActionVisitorTemplateMergeV2<CusarchInfo, CusarchInfo> {
	
	public VisiCusarchMergeToSelect(DeciTreeOption<CusarchInfo> option) {
		super(option, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CusarchInfo>> getActionClassHook() {
		return StdCusarchDaoSelect.class;
	}
	
	
	
	@Override protected List<CusarchInfo> mergeHook(List<CusarchInfo> baseInfos, List<CusarchInfo> selectedInfos) {	
		return CusarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
