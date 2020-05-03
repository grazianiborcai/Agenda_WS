package br.com.mind5.payment.setupPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class LazySetuparMergePaypar extends ActionLazyTemplateV2<SetuparInfo, SetuparInfo> {
	
	public LazySetuparMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SetuparInfo> translateRecordInfosHook(List<SetuparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SetuparInfo> getInstanceOfActionHook(DeciTreeOption<SetuparInfo> option) {
		return new StdSetuparMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<SetuparInfo> translateResultHook(DeciResult<SetuparInfo> result) {
		return result;
	}
}
