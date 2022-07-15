package br.com.mind5.webhook.moipRefund.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.RootPaytusRefresh;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class WokefumoipVisiPaytusRefresh extends ActionVisitorTemplateAction<WokefumoipInfo, PaytusInfo> {
	
	public WokefumoipVisiPaytusRefresh(DeciTreeOption<WokefumoipInfo> option) {
		super(option, WokefumoipInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusInfo>> getTreeClassHook() {
		return RootPaytusRefresh.class;
	}
	
	
	
	@Override protected List<WokefumoipInfo> toBaseClassHook(List<WokefumoipInfo> baseInfos, List<PaytusInfo> results) {
		return baseInfos;
	}
}
