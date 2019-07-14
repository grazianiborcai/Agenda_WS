package br.com.gda.payment.partnerMoip.permissionMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.storePartner.info.StoparCopier;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.decisionTree.RootStoparInsert;

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
