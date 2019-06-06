package br.com.gda.business.personList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPersolisSelect extends ActionLazyTemplate<PersolisInfo, PersolisInfo> {
	
	public LazyPersolisSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersolisInfo> translateRecordInfosHook(List<PersolisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PersolisInfo> getInstanceOfActionHook(DeciTreeOption<PersolisInfo> option) {
		return new StdPersolisSelect(option);
	}
	
	
	
	@Override protected DeciResult<PersolisInfo> translateResultHook(DeciResult<PersolisInfo> result) {
		return result;
	}
}
