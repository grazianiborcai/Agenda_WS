package br.com.mind5.business.orderSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdnapMergeUselis_ extends ActionLazyTemplate<OrdnapInfo, OrdnapInfo> {

	public LazyOrdnapMergeUselis_(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdnapInfo> translateRecordInfosHook(List<OrdnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdnapInfo> getInstanceOfActionHook(DeciTreeOption<OrdnapInfo> option) {
		return new StdOrdnapMergeUselis(option);
	}
	
	
	
	@Override protected DeciResult<OrdnapInfo> translateResultHook(DeciResult<OrdnapInfo> result) {
		return result;
	}
}
