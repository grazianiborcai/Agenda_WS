package br.com.gda.business.cartItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class CartemMergerUsername extends InfoMergerTemplate<CartemInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, UsernameInfo> getVisitorHook() {
		return new CartemVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
