package br.com.mind5.business.customerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCusnapMergeUselis extends ActionLazyTemplateV1<CusnapInfo, CusnapInfo> {
	
	public LazyCusnapMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusnapInfo> translateRecordInfosHook(List<CusnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CusnapInfo> getInstanceOfActionHook(DeciTreeOption<CusnapInfo> option) {
		return new StdCusnapMergeUselis(option);
	}
	
	
	
	@Override protected DeciResult<CusnapInfo> translateResultHook(DeciResult<CusnapInfo> result) {
		return result;
	}
}
