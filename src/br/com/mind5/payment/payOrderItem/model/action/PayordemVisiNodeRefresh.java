package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.PayordemNodeRefresh;

public final class PayordemVisiNodeRefresh extends ActionVisitorTemplateAction<PayordemInfo, PayordemInfo> {

	public PayordemVisiNodeRefresh(DeciTreeOption<PayordemInfo> option) {
		super(option, PayordemInfo.class, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return PayordemNodeRefresh.class;
	}
	
	
	
	@Override protected List<PayordemInfo> toBaseClassHook(List<PayordemInfo> baseInfos, List<PayordemInfo> results) {
		return results;
	}
}
