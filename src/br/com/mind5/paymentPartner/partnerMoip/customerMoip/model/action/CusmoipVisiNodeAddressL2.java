package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree.CusmoipNodeAddressL2;

public final class CusmoipVisiNodeAddressL2 extends ActionVisitorTemplateAction<CusmoipInfo, CusmoipInfo> {

	public CusmoipVisiNodeAddressL2(DeciTreeOption<CusmoipInfo> option) {
		super(option, CusmoipInfo.class, CusmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusmoipInfo>> getTreeClassHook() {
		return CusmoipNodeAddressL2.class;
	}
	
	
	
	@Override protected List<CusmoipInfo> toBaseClassHook(List<CusmoipInfo> baseInfos, List<CusmoipInfo> results) {
		return results;
	}
}
