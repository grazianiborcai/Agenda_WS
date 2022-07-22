package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree.PaymoipNodeSetuparL1;

public final class PaymoipVisiNodeSetuparL1 extends ActionVisitorTemplateAction<PaymoipInfo, PaymoipInfo> {

	public PaymoipVisiNodeSetuparL1(DeciTreeOption<PaymoipInfo> option) {
		super(option, PaymoipInfo.class, PaymoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaymoipInfo>> getTreeClassHook() {
		return PaymoipNodeSetuparL1.class;
	}
	
	
	
	@Override protected List<PaymoipInfo> toBaseClassHook(List<PaymoipInfo> baseInfos, List<PaymoipInfo> results) {
		return results;
	}
}
