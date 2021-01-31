package br.com.mind5.business.cartCounter.model.checker;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartouCheckLangu extends ModelCheckerTemplateForward<CartouInfo, LanguInfo> {
	
	public CartouCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(CartouInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
