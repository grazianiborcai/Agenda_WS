package br.com.mind5.business.orderSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdnapMergeToSelect extends ActionLazyTemplateV1<OrdnapInfo, OrdnapInfo> {

	public LazyOrdnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdnapInfo> translateRecordInfosHook(List<OrdnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrdnapInfo> getInstanceOfActionHook(DeciTreeOption<OrdnapInfo> option) {
		return new StdOrdnapMergeToSelect(option);
	}
	
	
	
	@Override protected DeciResult<OrdnapInfo> translateResultHook(DeciResult<OrdnapInfo> result) {
		return result;
	}
}
