package br.com.mind5.business.personBioSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.business.personBioSnapshot.model.decisionTree.RootPerbionapSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPerbionapRootSelect extends ActionLazyTemplate<PerbionapInfo, PerbionapInfo> {

	public LazyPerbionapRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PerbionapInfo> translateRecordInfosHook(List<PerbionapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PerbionapInfo> getInstanceOfActionHook(DeciTreeOption<PerbionapInfo> option) {
		return new RootPerbionapSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PerbionapInfo> translateResultHook(DeciResult<PerbionapInfo> result) {
		return result;
	}
}
