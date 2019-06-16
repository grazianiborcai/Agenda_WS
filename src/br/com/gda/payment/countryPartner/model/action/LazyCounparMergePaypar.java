package br.com.gda.payment.countryPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.countryPartner.info.CounparInfo;

public final class LazyCounparMergePaypar extends ActionLazyTemplate<CounparInfo, CounparInfo> {
	
	public LazyCounparMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CounparInfo> translateRecordInfosHook(List<CounparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CounparInfo> getInstanceOfActionHook(DeciTreeOption<CounparInfo> option) {
		return new StdCounparMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<CounparInfo> translateResultHook(DeciResult<CounparInfo> result) {
		return result;
	}
}
