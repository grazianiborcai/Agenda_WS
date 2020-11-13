package br.com.mind5.business.scheduleDayData.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedaytaCheckOwner extends ModelCheckerTemplateForward<SchedaytaInfo, OwnerInfo> {
	
	public SchedaytaCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SchedaytaInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
