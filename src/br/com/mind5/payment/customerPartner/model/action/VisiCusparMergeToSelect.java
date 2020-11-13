package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

final class VisiCusparMergeToSelect extends ActionVisitorTemplateMerge<CusparInfo, CusparInfo> {
	
	public VisiCusparMergeToSelect(DeciTreeOption<CusparInfo> option) {
		super(option, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CusparInfo>> getActionClassHook() {
		return StdCusparDaoSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return CusparMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
