package br.com.gda.business.orderSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOrdnapSelect extends ActionLazyTemplate<OrdnapInfo, OrdnapInfo> {

	public LazyOrdnapSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdnapInfo> translateRecordInfosHook(List<OrdnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdnapInfo> getInstanceOfActionHook(DeciTreeOption<OrdnapInfo> option) {
		return new StdOrdnapSelect(option);
	}
	
	
	
	@Override protected DeciResult<OrdnapInfo> translateResultHook(DeciResult<OrdnapInfo> result) {
		return result;
	}
}
