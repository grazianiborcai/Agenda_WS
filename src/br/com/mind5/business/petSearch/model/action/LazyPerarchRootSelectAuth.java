package br.com.mind5.business.petSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.decisionTree.RootPerarchSelectAuth;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPerarchRootSelectAuth extends ActionLazyTemplate<PetarchInfo, PetarchInfo> {

	public LazyPerarchRootSelectAuth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PetarchInfo> translateRecordInfosHook(List<PetarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PetarchInfo> getInstanceOfActionHook(DeciTreeOption<PetarchInfo> option) {
		return new RootPerarchSelectAuth(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PetarchInfo> translateResultHook(DeciResult<PetarchInfo> result) {
		return result;
	}
}
