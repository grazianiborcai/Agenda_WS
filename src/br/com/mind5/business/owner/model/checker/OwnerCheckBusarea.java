package br.com.mind5.business.owner.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.checker.BusareaCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OwnerCheckBusarea extends ModelCheckerTemplateForward<OwnerInfo, BusareaInfo> {
	
	public OwnerCheckBusarea(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<BusareaInfo> getCheckerHook(ModelCheckerOption option) {
		return new BusareaCheckExist(option);
	}
	
	
	
	@Override protected BusareaInfo toForwardClass(OwnerInfo baseRecord) {
		return BusareaInfo.copyFrom(baseRecord);
	}
}
