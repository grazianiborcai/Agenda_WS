package br.com.mind5.payment.partnerMoip.permissionMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.decisionTree.NodePeresmoipCode;

public final class LazyPeresmoipNodeCode extends ActionLazyTemplate<PeresmoipInfo, PeresmoipInfo> {
	
	public LazyPeresmoipNodeCode(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PeresmoipInfo> translateRecordInfosHook(List<PeresmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PeresmoipInfo> getInstanceOfActionHook(DeciTreeOption<PeresmoipInfo> option) {
		return new NodePeresmoipCode(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PeresmoipInfo> translateResultHook(DeciResult<PeresmoipInfo> result) {
		return result;
	}
}
