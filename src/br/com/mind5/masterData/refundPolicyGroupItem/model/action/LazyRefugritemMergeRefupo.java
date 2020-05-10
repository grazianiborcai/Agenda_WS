package br.com.mind5.masterData.refundPolicyGroupItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefugritemMergeRefupo extends ActionLazyTemplateV2<RefugritemInfo, RefugritemInfo> {

	public LazyRefugritemMergeRefupo(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefugritemInfo> translateRecordInfosHook(List<RefugritemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefugritemInfo> getInstanceOfActionHook(DeciTreeOption<RefugritemInfo> option) {
		return new StdRefugritemMergeRefupo(option);
	}
	
	
	
	@Override protected DeciResult<RefugritemInfo> translateResultHook(DeciResult<RefugritemInfo> result) {
		return result;
	}
}