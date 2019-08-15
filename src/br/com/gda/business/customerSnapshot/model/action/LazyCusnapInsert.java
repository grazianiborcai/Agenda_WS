package br.com.gda.business.customerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCusnapInsert extends ActionLazyTemplate<CusnapInfo, CusnapInfo> {
	
	public LazyCusnapInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusnapInfo> translateRecordInfosHook(List<CusnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusnapInfo> getInstanceOfActionHook(DeciTreeOption<CusnapInfo> option) {
		return new StdCusnapInsert(option);
	}
	
	
	
	@Override protected DeciResult<CusnapInfo> translateResultHook(DeciResult<CusnapInfo> result) {
		return result;
	}
}
