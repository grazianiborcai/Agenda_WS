package br.com.mind5.webhook.moipMultipayment.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.PaytusRootRefresh;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class WokaymoipVisiPaytusRefresh extends ActionVisitorTemplateAction<WokaymoipInfo, PaytusInfo> {
	
	public WokaymoipVisiPaytusRefresh(DeciTreeOption<WokaymoipInfo> option) {
		super(option, WokaymoipInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusInfo>> getTreeClassHook() {
		return PaytusRootRefresh.class;
	}
	
	
	
	@Override protected List<WokaymoipInfo> toBaseClassHook(List<WokaymoipInfo> baseInfos, List<PaytusInfo> results) {
		return baseInfos;
	}
}
