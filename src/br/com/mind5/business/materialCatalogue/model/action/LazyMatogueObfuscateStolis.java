package br.com.mind5.business.materialCatalogue.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatogueObfuscateStolis extends ActionLazyTemplate<MatogueInfo, MatogueInfo> {
	
	public LazyMatogueObfuscateStolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatogueInfo> translateRecordInfosHook(List<MatogueInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<MatogueInfo> getInstanceOfActionHook(DeciTreeOption<MatogueInfo> option) {
		return new StdMatogueObfuscateStolis(option);
	}
	
	
	
	@Override protected DeciResult<MatogueInfo> translateResultHook(DeciResult<MatogueInfo> result) {
		return result;
	}
}
