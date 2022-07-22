package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.PaytusNodeRefresh;

public final class PaytusVisiNodeRefresh extends ActionVisitorTemplateAction<PaytusInfo, PaytusInfo> {

	public PaytusVisiNodeRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option, PaytusInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusInfo>> getTreeClassHook() {
		return PaytusNodeRefresh.class;
	}
	
	
	
	@Override protected List<PaytusInfo> toBaseClassHook(List<PaytusInfo> baseInfos, List<PaytusInfo> results) {
		return results;
	}
}
