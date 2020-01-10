package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

final class CartemMergerSymsg extends InfoMergerTemplate<CartemInfo, SymsgInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, SymsgInfo> getVisitorHook() {
		return new CartemVisiMergeSymsg();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
