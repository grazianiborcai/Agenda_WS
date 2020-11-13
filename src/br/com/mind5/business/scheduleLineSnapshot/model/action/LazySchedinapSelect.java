package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedinapSelect extends ActionLazyTemplate<SchedinapInfo, SchedinapInfo> {

	public LazySchedinapSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedinapInfo> translateRecordInfosHook(List<SchedinapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedinapInfo> getInstanceOfActionHook(DeciTreeOption<SchedinapInfo> option) {
		return new StdSchedinapDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<SchedinapInfo> translateResultHook(DeciResult<SchedinapInfo> result) {
		return result;
	}
}
