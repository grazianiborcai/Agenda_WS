package br.com.mind5.business.customerList.info;


import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CuslisCopyCart extends InfoCopierTemplate<CuslisInfo, CartInfo>{
	
	public CuslisCopyCart() {
		super();
	}
	
	
	
	@Override protected CuslisInfo makeCopyHook(CartInfo source) {
		CuslisInfo result = new CuslisInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;

		return result;
	}
}
