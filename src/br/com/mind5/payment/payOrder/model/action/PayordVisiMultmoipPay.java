package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipCopier;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree.MultmoipRootPay;

public final class PayordVisiMultmoipPay extends ActionVisitorTemplateAction<PayordInfo, MultmoipInfo> {
	
	public PayordVisiMultmoipPay(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class, MultmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MultmoipInfo>> getTreeClassHook() {
		return MultmoipRootPay.class;
	}
	
	
	
	@Override protected List<MultmoipInfo> toActionClassHook(List<PayordInfo> baseInfos) {
		return MultmoipCopier.copyFromPayord(baseInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<MultmoipInfo> selectedInfos) {
		return PayordMerger.mergeWithMultmoip(baseInfos, selectedInfos);
	}
}
