package br.com.mind5.business.personSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.RootPersonapSelect;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPersonapRootSelect extends ActionLazyTemplateV2<PersonapInfo, PersonapInfo> {
	
	public LazyPersonapRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonapInfo> translateRecordInfosHook(List<PersonapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PersonapInfo> getInstanceOfActionHook(DeciTreeOption<PersonapInfo> option) {
		return new RootPersonapSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PersonapInfo> translateResultHook(DeciResult<PersonapInfo> result) {
		return result;
	}
}
