package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree.PaymoipNodeSysparL1;

public final class PaymoipVisiNodeSysparL1 extends ActionVisitorTemplateAction<PaymoipInfo, PaymoipInfo> {

	public PaymoipVisiNodeSysparL1(DeciTreeOption<PaymoipInfo> option) {
		super(option, PaymoipInfo.class, PaymoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaymoipInfo>> getTreeClassHook() {
		return PaymoipNodeSysparL1.class;
	}
	
	
	
	@Override protected List<PaymoipInfo> toBaseClassHook(List<PaymoipInfo> baseInfos, List<PaymoipInfo> results) {
		return results;
	}
}
