package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

final class CartemMergerSymsg extends InfoMergerTemplate_<CartemInfo, SymsgInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, SymsgInfo> getVisitorHook() {
		return new CartemVisiMergeSymsg();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
