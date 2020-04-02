package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree.RootPeresmoipInsert;

final class VisiAccemoipInsertPeresmoip extends ActionVisitorTemplateAction<AccemoipInfo, PeresmoipInfo> {
	public VisiAccemoipInsertPeresmoip(Connection conn, String schemaName) {
		super(conn, schemaName, AccemoipInfo.class, PeresmoipInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PeresmoipInfo> getActionHook(DeciTreeOption<PeresmoipInfo> option) {
		return new RootPeresmoipInsert(option).toAction();
	}
	
	
	
	@Override protected List<AccemoipInfo> toBaseClassHook(List<AccemoipInfo> baseInfos, List<PeresmoipInfo> results) {
		return baseInfos;
	}
}
