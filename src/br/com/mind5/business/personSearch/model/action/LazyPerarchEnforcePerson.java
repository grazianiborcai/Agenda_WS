package br.com.mind5.business.personSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPerarchEnforcePerson extends ActionLazyTemplateV2<PerarchInfo, PerarchInfo> {
	
	public LazyPerarchEnforcePerson(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PerarchInfo> translateRecordInfosHook(List<PerarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PerarchInfo> getInstanceOfActionHook(DeciTreeOption<PerarchInfo> option) {
		return new StdPerarchEnforcePerson(option);
	}
	
	
	
	@Override protected DeciResult<PerarchInfo> translateResultHook(DeciResult<PerarchInfo> result) {		
		return result;
	}
}
