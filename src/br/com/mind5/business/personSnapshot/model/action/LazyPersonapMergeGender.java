package br.com.mind5.business.personSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPersonapMergeGender extends ActionLazyTemplateV2<PersonapInfo, PersonapInfo> {
	
	public LazyPersonapMergeGender(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonapInfo> translateRecordInfosHook(List<PersonapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PersonapInfo> getInstanceOfActionHook(DeciTreeOption<PersonapInfo> option) {
		return new StdPersonapMergeGender(option);
	}
	
	
	
	@Override protected DeciResult<PersonapInfo> translateResultHook(DeciResult<PersonapInfo> result) {
		return result;
	}
}
