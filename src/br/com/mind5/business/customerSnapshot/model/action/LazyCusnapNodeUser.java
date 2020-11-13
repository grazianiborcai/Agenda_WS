package br.com.mind5.business.customerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.decisionTree.NodeCusnapUser;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCusnapNodeUser extends ActionLazyTemplate<CusnapInfo, CusnapInfo> {
	
	public LazyCusnapNodeUser(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusnapInfo> translateRecordInfosHook(List<CusnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusnapInfo> getInstanceOfActionHook(DeciTreeOption<CusnapInfo> option) {
		return new NodeCusnapUser(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CusnapInfo> translateResultHook(DeciResult<CusnapInfo> result) {
		return result;
	}
}
