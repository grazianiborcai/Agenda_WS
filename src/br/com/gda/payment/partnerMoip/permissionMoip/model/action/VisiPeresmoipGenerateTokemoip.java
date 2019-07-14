package br.com.gda.payment.partnerMoip.permissionMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.partnerMoip.permissionMoip.info.PeresmoipMerger;
import br.com.gda.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.gda.payment.partnerMoip.tokenMoip.model.decisionTree.RootTokemoipGenerate;

final class VisiPeresmoipGenerateTokemoip extends ActionVisitorTemplateAction<PeresmoipInfo, TokemoipInfo> {
	public VisiPeresmoipGenerateTokemoip(Connection conn, String schemaName) {
		super(conn, schemaName, PeresmoipInfo.class, TokemoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<TokemoipInfo> getActionHook(DeciTreeOption<TokemoipInfo> option) {
		return new RootTokemoipGenerate(option).toAction();
	}
	
	
	
	@Override protected List<PeresmoipInfo> toBaseClassHook(List<PeresmoipInfo> baseInfos, List<TokemoipInfo> results) {
		return PeresmoipMerger.mergeWithTokemoip(results, baseInfos);
	}
}
