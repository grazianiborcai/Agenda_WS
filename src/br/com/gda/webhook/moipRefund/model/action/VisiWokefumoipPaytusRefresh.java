package br.com.gda.webhook.moipRefund.model.action;

import java.sql.Connection;
import java.util.List;


import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.model.decisionTree.RootPaytusRefresh;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;

final class VisiWokefumoipPaytusRefresh extends ActionVisitorTemplateAction<WokefumoipInfo, PaytusInfo> {
	public VisiWokefumoipPaytusRefresh(Connection conn, String schemaName) {
		super(conn, schemaName, WokefumoipInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected ActionStd<PaytusInfo> getActionHook(DeciTreeOption<PaytusInfo> option) {
		return new RootPaytusRefresh(option).toAction();
	}
	
	
	
	@Override protected List<WokefumoipInfo> toBaseClassHook(List<WokefumoipInfo> baseInfos, List<PaytusInfo> results) {
		return baseInfos;
	}
}
