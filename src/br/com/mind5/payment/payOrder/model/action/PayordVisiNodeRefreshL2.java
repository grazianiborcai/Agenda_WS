package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.PayordNodeRefreshL2;

public final class PayordVisiNodeRefreshL2 extends ActionVisitorTemplateAction<PayordInfo, PayordInfo> {

	public PayordVisiNodeRefreshL2(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return PayordNodeRefreshL2.class;
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<PayordInfo> results) {
		return results;
	}
}
