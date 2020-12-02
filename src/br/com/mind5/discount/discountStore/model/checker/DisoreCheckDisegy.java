package br.com.mind5.discount.discountStore.model.checker;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.masterData.discountStrategy.model.checker.DisegyCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class DisoreCheckDisegy extends ModelCheckerTemplateForward<DisoreInfo, DisegyInfo> {
	
	public DisoreCheckDisegy(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<DisegyInfo> getCheckerHook(ModelCheckerOption option) {
		return new DisegyCheckExist(option);
	}
	
	
	
	@Override protected DisegyInfo toForwardClass(DisoreInfo baseRecord) {
		return DisegyInfo.copyFrom(baseRecord);
	}
}
