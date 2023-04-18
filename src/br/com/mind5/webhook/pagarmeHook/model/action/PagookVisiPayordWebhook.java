package br.com.mind5.webhook.pagarmeHook.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.PayordRootWebhook;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookVisiPayordWebhook extends ActionVisitorTemplateAction<PagookInfo, PayordInfo> {
	
	public PagookVisiPayordWebhook(DeciTreeOption<PagookInfo> option) {
		super(option, PagookInfo.class, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return PayordRootWebhook.class;
	}
	
	
	
	@Override protected List<PagookInfo> toBaseClassHook(List<PagookInfo> baseInfos, List<PayordInfo> results) {
		return baseInfos;
	}
}
