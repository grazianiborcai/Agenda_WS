package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.decisionTree.PaytusemRootRefresh;

public final class PaytusVisiPaytusemRefresh extends ActionVisitorTemplateAction<PaytusInfo, PaytusemInfo> {
	
	public PaytusVisiPaytusemRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option, PaytusInfo.class, PaytusemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusemInfo>> getTreeClassHook() {
		return PaytusemRootRefresh.class;
	}
	
	

	@Override protected List<PaytusInfo> toBaseClassHook(List<PaytusInfo> baseInfos, List<PaytusemInfo> results) {	
		return PaytusMerger.mergeWithPaytusem(baseInfos, results);
	}
}
