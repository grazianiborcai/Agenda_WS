package br.com.mind5.payment.statusPayOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.decisionTree.PaytusemNodeRefresh;

public final class PaytusemVisiNodeRefresh extends ActionVisitorTemplateAction<PaytusemInfo, PaytusemInfo> {

	public PaytusemVisiNodeRefresh(DeciTreeOption<PaytusemInfo> option) {
		super(option, PaytusemInfo.class, PaytusemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusemInfo>> getTreeClassHook() {
		return PaytusemNodeRefresh.class;
	}
	
	
	
	@Override protected List<PaytusemInfo> toBaseClassHook(List<PaytusemInfo> baseInfos, List<PaytusemInfo> results) {
		return results;
	}
}
