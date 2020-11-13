package br.com.mind5.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.NodePhoneDefaultL1;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPhoneNodeDefaultL1 extends ActionLazyTemplate<PhoneInfo, PhoneInfo> {

	public LazyPhoneNodeDefaultL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PhoneInfo> translateRecordInfosHook(List<PhoneInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PhoneInfo> getInstanceOfActionHook(DeciTreeOption<PhoneInfo> option) {
		return new NodePhoneDefaultL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PhoneInfo> translateResultHook(DeciResult<PhoneInfo> result) {
		return result;
	}
}
