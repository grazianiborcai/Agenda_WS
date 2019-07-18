package br.com.gda.payment.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipMerger;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipCopier;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.model.decsionTree.RootOrdmoipMaterial;

final class VisiMultmoipPlaceMat extends ActionVisitorTemplateAction<MultmoipInfo, OrdmoipInfo> {
	public VisiMultmoipPlaceMat(Connection conn, String schemaName) {
		super(conn, schemaName, MultmoipInfo.class, OrdmoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrdmoipInfo> getActionHook(DeciTreeOption<OrdmoipInfo> option) {
		return new RootOrdmoipMaterial(option).toAction();
	}
	
	
	
	@Override protected List<OrdmoipInfo> toActionClassHook(List<MultmoipInfo> baseInfos) {
		return OrdmoipCopier.copyFromMultmoip(baseInfos);
	}
	
	
	
	@Override protected List<MultmoipInfo> toBaseClassHook(List<MultmoipInfo> baseInfos, List<OrdmoipInfo> results) {
		return MultmoipMerger.mergeWithOrdmoip(results, baseInfos);
	}
}
