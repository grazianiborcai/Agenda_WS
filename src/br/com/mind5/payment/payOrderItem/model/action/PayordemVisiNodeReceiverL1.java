package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.PayordemNodeReceiverL1;

public final class PayordemVisiNodeReceiverL1 extends ActionVisitorTemplateAction<PayordemInfo, PayordemInfo> {

	public PayordemVisiNodeReceiverL1(DeciTreeOption<PayordemInfo> option) {
		super(option, PayordemInfo.class, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return PayordemNodeReceiverL1.class;
	}
	
	
	
	@Override protected List<PayordemInfo> toBaseClassHook(List<PayordemInfo> baseInfos, List<PayordemInfo> results) {
		return results;
	}
}
