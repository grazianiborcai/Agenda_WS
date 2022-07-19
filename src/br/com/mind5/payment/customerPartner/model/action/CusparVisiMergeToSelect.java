package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

public final class CusparVisiMergeToSelect extends ActionVisitorTemplateMerge<CusparInfo, CusparInfo> {
	
	public CusparVisiMergeToSelect(DeciTreeOption<CusparInfo> option) {
		super(option, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CusparInfo>> getVisitorClassHook() {
		return CusparVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return CusparMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
