package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.PayordNodeInsertL1;

public final class PayordVisiNodeInsertL1 extends ActionVisitorTemplateAction<PayordInfo, PayordInfo> {

	public PayordVisiNodeInsertL1(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return PayordNodeInsertL1.class;
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<PayordInfo> results) {
		return results;
	}
}
