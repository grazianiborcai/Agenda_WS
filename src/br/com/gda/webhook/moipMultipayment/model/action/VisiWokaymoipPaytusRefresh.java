package br.com.gda.webhook.moipMultipayment.model.action;

import java.sql.Connection;
import java.util.List;


import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.model.decisionTree.RootPaytusRefresh;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;

final class VisiWokaymoipPaytusRefresh extends ActionVisitorTemplateAction<WokaymoipInfo, PaytusInfo> {
	public VisiWokaymoipPaytusRefresh(Connection conn, String schemaName) {
		super(conn, schemaName, WokaymoipInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected ActionStd<PaytusInfo> getActionHook(DeciTreeOption<PaytusInfo> option) {
		return new RootPaytusRefresh(option).toAction();
	}
	
	
	
	@Override protected List<WokaymoipInfo> toBaseClassHook(List<WokaymoipInfo> baseInfos, List<PaytusInfo> results) {
		return baseInfos;
	}
}
