package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaMerger;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootSelect;

public final class CustopaVisiMergeUser extends ActionVisitorTemplateMerge<CustopaInfo, UserInfo> {
	
	public CustopaVisiMergeUser(DeciTreeOption<CustopaInfo> option) {
		super(option, UserInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserRootSelect.class;
	}
	
	
	
	@Override protected List<CustopaInfo> mergeHook(List<CustopaInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return CustopaMerger.mergeWithUser(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
