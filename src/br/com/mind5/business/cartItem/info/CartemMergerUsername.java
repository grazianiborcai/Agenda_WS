package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class CartemMergerUsername extends InfoMergerTemplate_<CartemInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, UsernameInfo> getVisitorHook() {
		return new CartemVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
