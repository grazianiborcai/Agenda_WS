package br.com.mind5.business.petSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.decisionTree.RootPetarchSelectCus;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPetarchRootSelectCus extends ActionLazyTemplate<PetarchInfo, PetarchInfo> {

	public LazyPetarchRootSelectCus(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PetarchInfo> translateRecordInfosHook(List<PetarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PetarchInfo> getInstanceOfActionHook(DeciTreeOption<PetarchInfo> option) {
		return new RootPetarchSelectCus(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PetarchInfo> translateResultHook(DeciResult<PetarchInfo> result) {
		return result;
	}
}
