package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.PaytusRootRefresh;

public final class PaytusVisiRootRefresh extends ActionVisitorTemplateAction<PaytusInfo, PaytusInfo> {

	public PaytusVisiRootRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option, PaytusInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusInfo>> getTreeClassHook() {
		return PaytusRootRefresh.class;
	}
	
	
	
	@Override protected List<PaytusInfo> toBaseClassHook(List<PaytusInfo> baseInfos, List<PaytusInfo> results) {
		return results;
	}
}
