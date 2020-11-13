package br.com.mind5.business.calendarMoon.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMooncalMergeMoonase extends ActionLazyTemplate<MooncalInfo, MooncalInfo> {
	
	public LazyMooncalMergeMoonase(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MooncalInfo> translateRecordInfosHook(List<MooncalInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<MooncalInfo> getInstanceOfActionHook(DeciTreeOption<MooncalInfo> option) {
		return new StdMooncalMergeMoonase(option);
	}
	
	
	
	@Override protected DeciResult<MooncalInfo> translateResultHook(DeciResult<MooncalInfo> result) {
		return result;
	}
}
