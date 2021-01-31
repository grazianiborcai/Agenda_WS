package br.com.mind5.business.cartCounter.model.checker;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartouCheckOwner extends ModelCheckerTemplateForward<CartouInfo, OwnerInfo> {
	
	public CartouCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CartouInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
