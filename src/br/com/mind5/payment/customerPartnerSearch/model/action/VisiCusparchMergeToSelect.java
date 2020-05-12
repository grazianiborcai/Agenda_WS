package br.com.mind5.payment.customerPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchMerger;

final class VisiCusparchMergeToSelect extends ActionVisitorTemplateMergeV2<CusparchInfo, CusparchInfo> {
	
	public VisiCusparchMergeToSelect(DeciTreeOption<CusparchInfo> option) {
		super(option, CusparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CusparchInfo>> getActionClassHook() {
		return StdCusparchDaoSelect.class;
	}
	
	
	
	@Override protected List<CusparchInfo> mergeHook(List<CusparchInfo> baseInfos, List<CusparchInfo> selectedInfos) {	
		return CusparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
