package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.PayordRootRefresh;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;

public final class PaytusVisiPayordRefresh extends ActionVisitorTemplateAction<PaytusInfo, PayordInfo> {
	
	public PaytusVisiPayordRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option, PaytusInfo.class, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return PayordRootRefresh.class;
	}
	
	
	
	@Override protected List<PaytusInfo> toBaseClassHook(List<PaytusInfo> baseInfos, List<PayordInfo> results) {
		return PaytusMerger.mergeWithPayord(baseInfos, results);
	}
}
