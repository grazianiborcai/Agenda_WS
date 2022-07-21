package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemMerger;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree.RootRefumoipRefund;

public final class RefemVisiRefumoipRefund extends ActionVisitorTemplateAction<RefemInfo, RefumoipInfo> {
	
	public RefemVisiRefumoipRefund(DeciTreeOption<RefemInfo> option) {
		super(option, RefemInfo.class, RefumoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefumoipInfo>> getTreeClassHook() {
		return RootRefumoipRefund.class;
	}
	
	
	
	@Override protected List<RefemInfo> toBaseClassHook(List<RefemInfo> baseInfos, List<RefumoipInfo> results) {	
		return RefemMerger.mergeWithRefumoip(baseInfos, results);
	}
}
