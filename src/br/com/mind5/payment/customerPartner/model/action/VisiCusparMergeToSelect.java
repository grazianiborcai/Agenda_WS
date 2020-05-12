package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

final class VisiCusparMergeToSelect extends ActionVisitorTemplateMergeV2<CusparInfo, CusparInfo> {
	
	public VisiCusparMergeToSelect(DeciTreeOption<CusparInfo> option) {
		super(option, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CusparInfo>> getActionClassHook() {
		return StdCusparDaoSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return CusparMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
