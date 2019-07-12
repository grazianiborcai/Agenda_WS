package br.com.gda.payment.tokenMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionMoip.model.decisionTree.RootPeresmoipInsert;

final class VisiAccemoipInsertPeresmoip extends ActionVisitorTemplateAction<TokemoipInfo, PeresmoipInfo> {
	public VisiAccemoipInsertPeresmoip(Connection conn, String schemaName) {
		super(conn, schemaName, TokemoipInfo.class, PeresmoipInfo.class);
	}
	
	
	
	@Override protected ActionStd<PeresmoipInfo> getActionHook(DeciTreeOption<PeresmoipInfo> option) {
		return new RootPeresmoipInsert(option).toAction();
	}
	
	
	
	@Override protected List<TokemoipInfo> toBaseClassHook(List<TokemoipInfo> baseInfos, List<PeresmoipInfo> results) {
		return baseInfos;
	}
}
