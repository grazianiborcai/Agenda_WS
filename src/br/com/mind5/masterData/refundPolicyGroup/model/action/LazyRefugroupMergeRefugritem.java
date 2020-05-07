package br.com.mind5.masterData.refundPolicyGroup.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefugroupMergeRefugritem extends ActionLazyTemplateV2<RefugroupInfo, RefugroupInfo> {

	public LazyRefugroupMergeRefugritem(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefugroupInfo> translateRecordInfosHook(List<RefugroupInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefugroupInfo> getInstanceOfActionHook(DeciTreeOption<RefugroupInfo> option) {
		return new StdRefugroupMergeRefugritem(option);
	}
	
	
	
	@Override protected DeciResult<RefugroupInfo> translateResultHook(DeciResult<RefugroupInfo> result) {
		return result;
	}
}
