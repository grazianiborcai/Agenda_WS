package br.com.mind5.business.personBio.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.decisionTree.NodePetSnapshot;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPerbioNodeSnapshot extends ActionLazyTemplate<PerbioInfo, PerbioInfo> {

	public LazyPerbioNodeSnapshot(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PerbioInfo> translateRecordInfosHook(List<PerbioInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PerbioInfo> getInstanceOfActionHook(DeciTreeOption<PerbioInfo> option) {
		return new NodePetSnapshot(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PerbioInfo> translateResultHook(DeciResult<PerbioInfo> result) {
		return result;
	}
}
