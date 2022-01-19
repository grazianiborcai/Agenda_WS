package br.com.mind5.business.pet.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPetEnforceLChanged extends ActionLazyTemplate<PetInfo, PetInfo> {
	
	public LazyPetEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PetInfo> translateRecordInfosHook(List<PetInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PetInfo> getInstanceOfActionHook(DeciTreeOption<PetInfo> option) {
		return new StdPetEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<PetInfo> translateResultHook(DeciResult<PetInfo> result) {
		return result;
	}
}
