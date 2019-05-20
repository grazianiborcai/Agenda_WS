package br.com.gda.business.personSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPersonapMergeGender extends ActionLazyTemplate<PersonapInfo, PersonapInfo> {
	
	public LazyPersonapMergeGender(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonapInfo> translateRecordInfosHook(List<PersonapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PersonapInfo> getInstanceOfActionHook(DeciTreeOption<PersonapInfo> option) {
		return new StdPersonapMergeGender(option);
	}
	
	
	
	@Override protected DeciResult<PersonapInfo> translateResultHook(DeciResult<PersonapInfo> result) {
		return result;
	}
}
