package br.com.gda.payment.setupPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class LazySetuparMergePaypar extends ActionLazyTemplate<SetuparInfo, SetuparInfo> {
	
	public LazySetuparMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SetuparInfo> translateRecordInfosHook(List<SetuparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SetuparInfo> getInstanceOfActionHook(DeciTreeOption<SetuparInfo> option) {
		return new StdSetuparMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<SetuparInfo> translateResultHook(DeciResult<SetuparInfo> result) {
		return result;
	}
}
