package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipMerger;
import br.com.mind5.security.userSnapshot.info.UserapCopier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.decisionTree.UserapRootSelect;

public final class CusmoipVisiMergeUserap extends ActionVisitorTemplateMerge<CusmoipInfo, UserapInfo> {
	
	public CusmoipVisiMergeUserap(DeciTreeOption<CusmoipInfo> option) {
		super(option, UserapInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserapInfo>> getTreeClassHook() {
		return UserapRootSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> toActionClassHook(List<CusmoipInfo> baseInfos) {
		return UserapCopier.copyFromCusmoip(baseInfos);	
	}
	
	
	
	@Override protected List<CusmoipInfo> mergeHook(List<CusmoipInfo> baseInfos, List<UserapInfo> selectedInfos) {	
		return CusmoipMerger.mergeWithUserap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
