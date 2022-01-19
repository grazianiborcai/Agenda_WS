package br.com.mind5.business.petSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPetsnapMergePetype extends ActionLazyTemplate<PetsnapInfo, PetsnapInfo> {
	
	public LazyPetsnapMergePetype(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PetsnapInfo> translateRecordInfosHook(List<PetsnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PetsnapInfo> getInstanceOfActionHook(DeciTreeOption<PetsnapInfo> option) {
		return new StdPetsnapMergePetype(option);
	}
	
	
	
	@Override protected DeciResult<PetsnapInfo> translateResultHook(DeciResult<PetsnapInfo> result) {
		return result;
	}
}
