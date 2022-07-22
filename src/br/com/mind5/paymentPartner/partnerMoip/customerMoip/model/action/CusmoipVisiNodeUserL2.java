package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree.CusmoipNodeUserL2;

public final class CusmoipVisiNodeUserL2 extends ActionVisitorTemplateAction<CusmoipInfo, CusmoipInfo> {

	public CusmoipVisiNodeUserL2(DeciTreeOption<CusmoipInfo> option) {
		super(option, CusmoipInfo.class, CusmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusmoipInfo>> getTreeClassHook() {
		return CusmoipNodeUserL2.class;
	}
	
	
	
	@Override protected List<CusmoipInfo> toBaseClassHook(List<CusmoipInfo> baseInfos, List<CusmoipInfo> results) {
		return results;
	}
}
