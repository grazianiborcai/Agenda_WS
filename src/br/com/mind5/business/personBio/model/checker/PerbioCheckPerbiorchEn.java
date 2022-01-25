package br.com.mind5.business.personBio.model.checker;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.checker.PerbiorchCheckExistEn;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PerbioCheckPerbiorchEn extends ModelCheckerTemplateForward<PerbioInfo, PerbiorchInfo> {
	
	public PerbioCheckPerbiorchEn(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PerbiorchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PerbiorchCheckExistEn(option);
	}
	
	
	
	@Override protected PerbiorchInfo toForwardClass(PerbioInfo baseRecord) {
		return PerbiorchInfo.copyFrom(baseRecord);
	}
}
