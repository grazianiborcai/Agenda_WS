package br.com.mind5.discount.discountStoreSnapshot.model.checker;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckExist;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class DisorapCheckDisore extends ModelCheckerTemplateForward<DisorapInfo, DisoreInfo> {
	
	public DisorapCheckDisore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<DisoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new DisoreCheckExist(option);
	}
	
	
	
	@Override protected DisoreInfo toForwardClass(DisorapInfo baseRecord) {
		return DisoreInfo.copyFrom(baseRecord);
	}
}
