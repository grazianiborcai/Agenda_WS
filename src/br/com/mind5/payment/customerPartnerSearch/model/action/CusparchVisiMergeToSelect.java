package br.com.mind5.payment.customerPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchMerger;

public final class CusparchVisiMergeToSelect extends ActionVisitorTemplateMerge<CusparchInfo, CusparchInfo> {
	
	public CusparchVisiMergeToSelect(DeciTreeOption<CusparchInfo> option) {
		super(option, CusparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CusparchInfo>> getVisitorClassHook() {
		return CusparchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CusparchInfo> mergeHook(List<CusparchInfo> baseInfos, List<CusparchInfo> selectedInfos) {	
		return CusparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
