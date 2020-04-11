package br.com.mind5.payment.countryPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class LazyCounparMergePaypar extends ActionLazyTemplateV1<CounparInfo, CounparInfo> {
	
	public LazyCounparMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CounparInfo> translateRecordInfosHook(List<CounparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CounparInfo> getInstanceOfActionHook(DeciTreeOption<CounparInfo> option) {
		return new StdCounparMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<CounparInfo> translateResultHook(DeciResult<CounparInfo> result) {
		return result;
	}
}
