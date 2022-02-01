package br.com.mind5.business.calendarMonthSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.model.decisionTree.RootCalontharchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalontharchRootSelect extends ActionLazyTemplate<CalontharchInfo, CalontharchInfo> {
	
	public LazyCalontharchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalontharchInfo> translateRecordInfosHook(List<CalontharchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CalontharchInfo> getInstanceOfActionHook(DeciTreeOption<CalontharchInfo> option) {
		return new RootCalontharchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CalontharchInfo> translateResultHook(DeciResult<CalontharchInfo> result) {
		return result;
	}
}
