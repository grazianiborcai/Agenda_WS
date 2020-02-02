package br.com.mind5.business.cart.info;

import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.security.username.info.UsernameInfo;

final class CartMergerUsername extends InfoMergerTemplateV2<CartInfo, UsernameInfo> {

	@Override protected CartInfo writeHook(UsernameInfo selectedInfo, CartInfo baseInfo) {
		baseInfo.codUser = selectedInfo.codUser;

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(UsernameInfo selectedInfo, CartInfo baseInfo) {
		if (selectedInfo.username == null ||
				baseInfo.username == null		)
			return false;
		
		return (selectedInfo.codOwner == baseInfo.codOwner		&&
				selectedInfo.username.equals(baseInfo.username)		);
	}
}
