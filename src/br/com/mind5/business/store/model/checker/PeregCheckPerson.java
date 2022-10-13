package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.checker.PeregCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PeregCheckPerson extends ModelCheckerTemplateForward<StoreInfo, PeregInfo> {
	
	public PeregCheckPerson(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PeregInfo> getCheckerHook(ModelCheckerOption option) {
		return new PeregCheckExist(option);
	}
	
	
	
	@Override protected PeregInfo toForwardClass(StoreInfo baseRecord) {
		return PeregInfo.copyFrom(baseRecord);
	}
}
