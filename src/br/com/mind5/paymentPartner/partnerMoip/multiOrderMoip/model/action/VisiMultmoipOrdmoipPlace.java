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
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.RootOrdmoipPlace;

final class VisiMultmoipOrdmoipPlace extends ActionVisitorTemplateAction<MultmoipInfo, OrdmoipInfo> {
	public VisiMultmoipOrdmoipPlace(Connection conn, String schemaName) {
		super(conn, schemaName, MultmoipInfo.class, OrdmoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrdmoipInfo> getActionHook(DeciTreeOption<OrdmoipInfo> option) {
		return new RootOrdmoipPlace(option).toAction();
	}
	
	
	
	@Override protected List<OrdmoipInfo> toActionClassHook(List<MultmoipInfo> baseInfos) {
		return OrdmoipCopier.copyFromMultmoipToPlace(baseInfos);
	}
	
	
	
	@Override protected List<MultmoipInfo> toBaseClassHook(List<MultmoipInfo> baseInfos, List<OrdmoipInfo> results) {
		return MultmoipMerger.mergeWithOrdmoip(results, baseInfos);
	}
}