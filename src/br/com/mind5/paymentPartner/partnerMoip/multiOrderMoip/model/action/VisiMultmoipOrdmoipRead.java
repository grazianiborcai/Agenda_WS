package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipMerger;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipCopier;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.RootOrdmoipRead;

final class VisiMultmoipOrdmoipRead extends ActionVisitorTemplateAction<MultmoipInfo, OrdmoipInfo> {
	public VisiMultmoipOrdmoipRead(Connection conn, String schemaName) {
		super(conn, schemaName, MultmoipInfo.class, OrdmoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrdmoipInfo> getActionHook(DeciTreeOption<OrdmoipInfo> option) {
		return new RootOrdmoipRead(option).toAction();
	}
	
	
	
	@Override protected List<OrdmoipInfo> toActionClassHook(List<MultmoipInfo> baseInfos) {
		return OrdmoipCopier.copyFromMultmoipToRead(baseInfos);
	}
	
	
	
	@Override protected List<MultmoipInfo> toBaseClassHook(List<MultmoipInfo> baseInfos, List<OrdmoipInfo> results) {
		return MultmoipMerger.mergeWithOrdmoip(baseInfos, results);
	}
}
