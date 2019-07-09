package br.com.gda.payment.permissionResponseMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionResponseMoip.model.decisionTree.NodePeresmoipCode;

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
