package br.com.mind5.business.materialCatalogue.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatogueObfuscateStolis extends ActionLazyTemplateV2<MatogueInfo, MatogueInfo> {
	
	public LazyMatogueObfuscateStolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatogueInfo> translateRecordInfosHook(List<MatogueInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatogueInfo> getInstanceOfActionHook(DeciTreeOption<MatogueInfo> option) {
		return new StdMatogueObfuscateStolis(option);
	}
	
	
	
	@Override protected DeciResult<MatogueInfo> translateResultHook(DeciResult<MatogueInfo> result) {
		return result;
	}
}
