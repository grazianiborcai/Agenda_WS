package br.com.mind5.business.person.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPersonUpdate extends ActionLazyTemplate<PersonInfo, PersonInfo> {
	
	public LazyPersonUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonInfo> translateRecordInfosHook(List<PersonInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PersonInfo> getInstanceOfActionHook(DeciTreeOption<PersonInfo> option) {
		return new StdPersonUpdate(option);
	}
	
	
	
	@Override protected DeciResult<PersonInfo> translateResultHook(DeciResult<PersonInfo> result) {
		return result;
	}
}
