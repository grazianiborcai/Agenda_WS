package br.com.mind5.business.addressSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyAddresnapMergeFormess extends ActionLazyTemplateV2<AddresnapInfo, AddresnapInfo> {
	
	public LazyAddresnapMergeFormess(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AddresnapInfo> translateRecordInfosHook(List<AddresnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<AddresnapInfo> getInstanceOfActionHook(DeciTreeOption<AddresnapInfo> option) {
		return new StdAddresnapMergeFormess(option);
	}
	
	
	
	@Override protected DeciResult<AddresnapInfo> translateResultHook(DeciResult<AddresnapInfo> result) {
		return result;
	}
}
