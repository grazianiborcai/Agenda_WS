package br.com.mind5.business.customerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.NodeCusarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCusarchNodeSelect extends ActionLazyTemplate<CusarchInfo, CusarchInfo> {
	
	public LazyCusarchNodeSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusarchInfo> translateRecordInfosHook(List<CusarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusarchInfo> getInstanceOfActionHook(DeciTreeOption<CusarchInfo> option) {
		return new NodeCusarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CusarchInfo> translateResultHook(DeciResult<CusarchInfo> result) {
		return result;
	}
}
