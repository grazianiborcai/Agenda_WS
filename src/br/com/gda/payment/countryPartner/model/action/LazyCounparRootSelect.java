package br.com.gda.payment.countryPartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.countryPartner.info.CounparInfo;
import br.com.gda.payment.countryPartner.model.decisionTree.RootCounparSelect;

public final class LazyCounparRootSelect extends ActionLazyTemplate<CounparInfo, CounparInfo> {
	
	public LazyCounparRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CounparInfo> translateRecordInfosHook(List<CounparInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CounparInfo> getInstanceOfActionHook(DeciTreeOption<CounparInfo> option) {
		return new RootCounparSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CounparInfo> translateResultHook(DeciResult<CounparInfo> result) {
		return result;
	}
}
