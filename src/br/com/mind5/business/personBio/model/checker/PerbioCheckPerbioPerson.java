package br.com.mind5.business.personBio.model.checker;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.checker.PerbiorchCheckExistPerson;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PerbioCheckPerbioPerson extends ModelCheckerTemplateForward<PerbioInfo, PerbiorchInfo> {
	
	public PerbioCheckPerbioPerson(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PerbiorchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PerbiorchCheckExistPerson(option);
	}
	
	
	
	@Override protected PerbiorchInfo toForwardClass(PerbioInfo baseRecord) {
		return PerbiorchInfo.copyFrom(baseRecord);
	}
}
