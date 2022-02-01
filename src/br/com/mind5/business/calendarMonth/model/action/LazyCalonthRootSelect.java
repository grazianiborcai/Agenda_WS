package br.com.mind5.business.calendarMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalonthRootSelect extends ActionLazyTemplate<CalonthInfo, CalonthInfo> {
	
	public LazyCalonthRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalonthInfo> translateRecordInfosHook(List<CalonthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CalonthInfo> getInstanceOfActionHook(DeciTreeOption<CalonthInfo> option) {
		return new RootCalonthSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CalonthInfo> translateResultHook(DeciResult<CalonthInfo> result) {
		return result;
	}
}
