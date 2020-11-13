package br.com.mind5.webhook.moipRefund.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.RootPaytusRefresh;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

final class VisiWokefumoipPaytusRefresh extends ActionVisitorTemplateAction<WokefumoipInfo, PaytusInfo> {
	
	public VisiWokefumoipPaytusRefresh(DeciTreeOption<WokefumoipInfo> option) {
		super(option, WokefumoipInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusInfo>> getTreeClassHook() {
		return RootPaytusRefresh.class;
	}
	
	
	
	@Override protected List<WokefumoipInfo> toBaseClassHook(List<WokefumoipInfo> baseInfos, List<PaytusInfo> results) {
		return baseInfos;
	}
}
