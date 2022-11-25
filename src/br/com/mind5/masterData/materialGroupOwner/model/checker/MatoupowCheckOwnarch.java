package br.com.mind5.masterData.materialGroupOwner.model.checker;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.checker.OwnarchCheckExistBusinessOwner;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class MatoupowCheckOwnarch extends ModelCheckerTemplateForward<MatoupowInfo, OwnarchInfo> {
	
	public MatoupowCheckOwnarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnarchCheckExistBusinessOwner(option);
	}
	
	
	
	@Override protected OwnarchInfo toForwardClass(MatoupowInfo baseRecord) {
		return OwnarchInfo.copyFrom(baseRecord);
	}
}
