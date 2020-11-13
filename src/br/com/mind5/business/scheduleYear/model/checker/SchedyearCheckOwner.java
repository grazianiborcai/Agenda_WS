package br.com.mind5.business.scheduleYear.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedyearCheckOwner extends ModelCheckerTemplateForward<SchedyearInfo, OwnerInfo> {
	
	public SchedyearCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SchedyearInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
