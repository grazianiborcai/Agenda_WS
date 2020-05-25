package br.com.mind5.business.scheduleDayData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.decisionTree.RootSchedaytaSelect;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedaytaRootSelect extends ActionLazyTemplateV2<SchedaytaInfo, SchedaytaInfo> {
	
	public LazySchedaytaRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedaytaInfo> translateRecordInfosHook(List<SchedaytaInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedaytaInfo> getInstanceOfActionHook(DeciTreeOption<SchedaytaInfo> option) {
		return new RootSchedaytaSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SchedaytaInfo> translateResultHook(DeciResult<SchedaytaInfo> result) {
		return result;
	}
}
