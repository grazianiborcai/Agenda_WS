package br.com.mind5.discount.discountStoreSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyDisorapMergeDisegy extends ActionLazyTemplate<DisorapInfo, DisorapInfo> {
	
	public LazyDisorapMergeDisegy(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<DisorapInfo> translateRecordInfosHook(List<DisorapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<DisorapInfo> getInstanceOfActionHook(DeciTreeOption<DisorapInfo> option) {
		return new StdDisorapMergeDisegy(option);
	}
	
	
	
	@Override protected DeciResult<DisorapInfo> translateResultHook(DeciResult<DisorapInfo> result) {
		return result;
	}
}
