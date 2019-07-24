package br.com.gda.payment.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipMerger;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipCopier;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.gda.payment.partnerMoip.multiPayMoip.model.decisionTree.RootPaymoipPay;

final class VisiMultmoipPaymoipPay extends ActionVisitorTemplateAction<MultmoipInfo, PaymoipInfo> {
	public VisiMultmoipPaymoipPay(Connection conn, String schemaName) {
		super(conn, schemaName, MultmoipInfo.class, PaymoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<PaymoipInfo> getActionHook(DeciTreeOption<PaymoipInfo> option) {
		return new RootPaymoipPay(option).toAction();
	}
	
	
	
	@Override protected List<PaymoipInfo> toActionClassHook(List<MultmoipInfo> baseInfos) {
		return PaymoipCopier.copyFromMultmoip(baseInfos);
	}
	
	
	
	@Override protected List<MultmoipInfo> toBaseClassHook(List<MultmoipInfo> baseInfos, List<PaymoipInfo> results) {
		return MultmoipMerger.mergeWithPaymoip(results, baseInfos);
	}
}
