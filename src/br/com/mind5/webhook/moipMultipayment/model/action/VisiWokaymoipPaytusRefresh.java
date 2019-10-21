package br.com.mind5.webhook.moipMultipayment.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.RootPaytusRefresh;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

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
