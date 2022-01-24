package br.com.mind5.business.personBioSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.decisionTree.RootPerbiorchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPerbiorchRootSelect extends ActionLazyTemplate<PerbiorchInfo, PerbiorchInfo> {

	public LazyPerbiorchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PerbiorchInfo> translateRecordInfosHook(List<PerbiorchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PerbiorchInfo> getInstanceOfActionHook(DeciTreeOption<PerbiorchInfo> option) {
		return new RootPerbiorchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PerbiorchInfo> translateResultHook(DeciResult<PerbiorchInfo> result) {
		return result;
	}
}
