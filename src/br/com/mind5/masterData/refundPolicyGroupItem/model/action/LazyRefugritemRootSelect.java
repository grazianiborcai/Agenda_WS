package br.com.mind5.masterData.refundPolicyGroupItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.decisionTree.RootRefugritemSelect;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefugritemRootSelect extends ActionLazyTemplateV2<RefugritemInfo, RefugritemInfo> {

	public LazyRefugritemRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefugritemInfo> translateRecordInfosHook(List<RefugritemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefugritemInfo> getInstanceOfActionHook(DeciTreeOption<RefugritemInfo> option) {
		return new RootRefugritemSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<RefugritemInfo> translateResultHook(DeciResult<RefugritemInfo> result) {
		return result;
	}
}
