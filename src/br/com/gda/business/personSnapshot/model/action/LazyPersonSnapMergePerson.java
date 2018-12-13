package br.com.gda.business.personSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPersonSnapMergePerson extends ActionLazyTemplate<PersonSnapInfo, PersonSnapInfo> {

	public LazyPersonSnapMergePerson(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonSnapInfo> translateRecordInfosHook(List<PersonSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PersonSnapInfo> getInstanceOfActionHook(DeciTreeOption<PersonSnapInfo> option) {
		return new StdPersonSnapMergePerson(option);
	}
	
	
	
	@Override protected DeciResult<PersonSnapInfo> translateResultHook(DeciResult<PersonSnapInfo> result) {
		return result;
	}
}
