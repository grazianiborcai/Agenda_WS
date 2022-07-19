package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.CusparchRootSelect;

public final class CusparVisiMergeCusparch extends ActionVisitorTemplateMerge<CusparInfo, CusparchInfo> {
	
	public CusparVisiMergeCusparch(DeciTreeOption<CusparInfo> option) {
		super(option, CusparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparchInfo>> getTreeClassHook() {
		return CusparchRootSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<CusparchInfo> selectedInfos) {	
		return CusparMerger.mergeWithCusparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
