package br.com.mind5.business.cart.model.checker;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartCheckOwner extends ModelCheckerTemplateForwardV2<CartInfo, OwnerInfo> {
	
	public CartCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CartInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
