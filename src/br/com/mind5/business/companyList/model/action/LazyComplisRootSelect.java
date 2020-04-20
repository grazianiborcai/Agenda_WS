package br.com.mind5.business.companyList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.decisionTree.RootComplisSelect;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyComplisRootSelect extends ActionLazyTemplateV2<ComplisInfo, ComplisInfo> {
	
	public LazyComplisRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<ComplisInfo> translateRecordInfosHook(List<ComplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<ComplisInfo> getInstanceOfActionHook(DeciTreeOption<ComplisInfo> option) {
		return new RootComplisSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<ComplisInfo> translateResultHook(DeciResult<ComplisInfo> result) {
		return result;
	}
}
