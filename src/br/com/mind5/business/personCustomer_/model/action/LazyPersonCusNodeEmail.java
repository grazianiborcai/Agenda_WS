package br.com.mind5.business.personCustomer_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personCustomer_.info.PersonCusInfo;
import br.com.mind5.business.personCustomer_.model.decisionTree.NodePersonCusEmail;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPersonCusNodeEmail extends ActionLazyTemplate<PersonCusInfo, PersonCusInfo> {
	
	public LazyPersonCusNodeEmail(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonCusInfo> translateRecordInfosHook(List<PersonCusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PersonCusInfo> getInstanceOfActionHook(DeciTreeOption<PersonCusInfo> option) {
		return new NodePersonCusEmail(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PersonCusInfo> translateResultHook(DeciResult<PersonCusInfo> result) {
		return result;
	}
}
