package br.com.mind5.webhook.pagarmeHook.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.PaytusRootRefresh;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookVisiPaytusRefresh extends ActionVisitorTemplateAction<PagookInfo, PaytusInfo> {
	
	public PagookVisiPaytusRefresh(DeciTreeOption<PagookInfo> option) {
		super(option, PagookInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusInfo>> getTreeClassHook() {
		return PaytusRootRefresh.class;
	}
	
	
	
	@Override protected List<PagookInfo> toBaseClassHook(List<PagookInfo> baseInfos, List<PaytusInfo> results) {
		return baseInfos;
	}
}
