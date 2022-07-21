package br.com.mind5.payment.refundOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.decisionTree.RefuNodeRefund;

public final class RefuVisiNodeRefund extends ActionVisitorTemplateAction<RefuInfo, RefuInfo> {

	public RefuVisiNodeRefund(DeciTreeOption<RefuInfo> option) {
		super(option, RefuInfo.class, RefuInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefuInfo>> getTreeClassHook() {
		return RefuNodeRefund.class;
	}
	
	
	
	@Override protected List<RefuInfo> toBaseClassHook(List<RefuInfo> baseInfos, List<RefuInfo> results) {
		return results;
	}
}
