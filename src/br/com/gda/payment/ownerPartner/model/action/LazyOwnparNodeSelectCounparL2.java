package br.com.gda.payment.ownerPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;
import br.com.gda.payment.ownerPartner.model.decisionTree.NodeOwnparSelectCounparL2;

public final class LazyOwnparNodeSelectCounparL2 extends ActionLazyTemplate<OwnparInfo, OwnparInfo> {
	
	public LazyOwnparNodeSelectCounparL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnparInfo> translateRecordInfosHook(List<OwnparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OwnparInfo> getInstanceOfActionHook(DeciTreeOption<OwnparInfo> option) {
		return new NodeOwnparSelectCounparL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OwnparInfo> translateResultHook(DeciResult<OwnparInfo> result) {
		return result;
	}
}
