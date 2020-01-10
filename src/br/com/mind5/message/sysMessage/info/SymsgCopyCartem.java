package br.com.mind5.message.sysMessage.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SymsgCopyCartem extends InfoCopierTemplate<SymsgInfo, CartemInfo>{
	
	public SymsgCopyCartem() {
		super();
	}
	
	
	
	@Override protected SymsgInfo makeCopyHook(CartemInfo source) {	
		return source.symsgData;
	}
}
