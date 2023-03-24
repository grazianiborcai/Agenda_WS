package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.decisionTree.PhonaultRootSelectUser;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

public final class CusparVisiMergePhonault extends ActionVisitorTemplateMerge<CusparInfo, PhonaultInfo> {
	
	public CusparVisiMergePhonault(DeciTreeOption<CusparInfo> option) {
		super(option, PhonaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonaultInfo>> getTreeClassHook() {
		return PhonaultRootSelectUser.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<PhonaultInfo> selectedInfos) {	
		return CusparMerger.mergeWithPhonault(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
