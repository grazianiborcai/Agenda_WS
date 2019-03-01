package br.com.gda.business.person.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPersonEnforceLChanged extends ActionLazyTemplate<PersonInfo, PersonInfo> {
	
	public LazyPersonEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonInfo> translateRecordInfosHook(List<PersonInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PersonInfo> getInstanceOfActionHook(DeciTreeOption<PersonInfo> option) {
		return new StdPersonEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<PersonInfo> translateResultHook(DeciResult<PersonInfo> result) {		
		return result;
	}
}
