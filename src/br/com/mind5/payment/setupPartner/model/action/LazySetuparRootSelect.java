package br.com.mind5.payment.setupPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;

public final class LazySetuparRootSelect extends ActionLazyTemplate<SetuparInfo, SetuparInfo> {
	
	public LazySetuparRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SetuparInfo> translateRecordInfosHook(List<SetuparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SetuparInfo> getInstanceOfActionHook(DeciTreeOption<SetuparInfo> option) {
		return new RootSetuparSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SetuparInfo> translateResultHook(DeciResult<SetuparInfo> result) {
		return result;
	}
}
