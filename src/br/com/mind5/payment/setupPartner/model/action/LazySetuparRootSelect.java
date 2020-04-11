package br.com.mind5.payment.setupPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;

public final class LazySetuparRootSelect extends ActionLazyTemplateV1<SetuparInfo, SetuparInfo> {
	
	public LazySetuparRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SetuparInfo> translateRecordInfosHook(List<SetuparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SetuparInfo> getInstanceOfActionHook(DeciTreeOption<SetuparInfo> option) {
		return new RootSetuparSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SetuparInfo> translateResultHook(DeciResult<SetuparInfo> result) {
		return result;
	}
}
