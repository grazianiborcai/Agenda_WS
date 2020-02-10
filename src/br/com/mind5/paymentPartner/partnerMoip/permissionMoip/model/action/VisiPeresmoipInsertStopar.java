package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparCopier;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.decisionTree.RootStoparInsert;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

final class VisiPeresmoipInsertStopar extends ActionVisitorTemplateAction<PeresmoipInfo, StoparInfo> {
	public VisiPeresmoipInsertStopar(Connection conn, String schemaName) {
		super(conn, schemaName, PeresmoipInfo.class, StoparInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoparInfo> getActionHook(DeciTreeOption<StoparInfo> option) {
		return new RootStoparInsert(option).toAction();
	}
	
	
	
	@Override protected List<StoparInfo> toActionClassHook(List<PeresmoipInfo> baseInfos) {
		return StoparCopier.copyFromPeresmoip(baseInfos);
	}
	
	
	
	@Override protected List<PeresmoipInfo> toBaseClassHook(List<PeresmoipInfo> baseInfos, List<StoparInfo> results) {
		return baseInfos;
	}
}