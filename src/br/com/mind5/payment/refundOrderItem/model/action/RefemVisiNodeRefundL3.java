package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.decisionTree.RefemNodeRefundL3;

public final class RefemVisiNodeRefundL3 extends ActionVisitorTemplateAction<RefemInfo, RefemInfo> {

	public RefemVisiNodeRefundL3(DeciTreeOption<RefemInfo> option) {
		super(option, RefemInfo.class, RefemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefemInfo>> getTreeClassHook() {
		return RefemNodeRefundL3.class;
	}
	
	
	
	@Override protected List<RefemInfo> toBaseClassHook(List<RefemInfo> baseInfos, List<RefemInfo> results) {
		return results;
	}
}
