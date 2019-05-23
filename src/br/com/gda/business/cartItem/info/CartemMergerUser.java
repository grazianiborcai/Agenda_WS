package br.com.gda.business.cartItem.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerUser extends InfoMergerTemplate<CartemInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, UserInfo> getVisitorHook() {
		return new CartemVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
