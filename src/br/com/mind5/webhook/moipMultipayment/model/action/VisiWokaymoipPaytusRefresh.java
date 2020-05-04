package br.com.mind5.webhook.moipMultipayment.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.RootPaytusRefresh;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

final class VisiWokaymoipPaytusRefresh extends ActionVisitorTemplateActionV2<WokaymoipInfo, PaytusInfo> {
	
	public VisiWokaymoipPaytusRefresh(DeciTreeOption<WokaymoipInfo> option) {
		super(option, WokaymoipInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusInfo>> getTreeClassHook() {
		return RootPaytusRefresh.class;
	}
	
	
	
	@Override protected List<WokaymoipInfo> toBaseClassHook(List<WokaymoipInfo> baseInfos, List<PaytusInfo> results) {
		return baseInfos;
	}
}
