package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class CartemMergerUsername extends InfoMergerTemplate<CartemInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, UsernameInfo> getVisitorHook() {
		return new CartemVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
