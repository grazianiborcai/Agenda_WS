package br.com.mind5.business.calendarCatalogue.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalgueMergeMatlis extends ActionLazyTemplate<CalgueInfo, CalgueInfo> {
	
	public LazyCalgueMergeMatlis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalgueInfo> translateRecordInfosHook(List<CalgueInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CalgueInfo> getInstanceOfActionHook(DeciTreeOption<CalgueInfo> option) {
		return new StdCalgueMergeMatlis(option);
	}
	
	
	
	@Override protected DeciResult<CalgueInfo> translateResultHook(DeciResult<CalgueInfo> result) {
		return result;
	}
}
