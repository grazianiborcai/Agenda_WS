package br.com.gda.business.schedule.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoCopierTemplate;

final class OrderemCopyCartem extends InfoCopierTemplate<ScheduInfo, CartemInfo>{
	
	public OrderemCopyCartem() {
		super();
	}
	
	
	
	@Override protected ScheduInfo makeCopyHook(CartemInfo source) {
		return ScheduInfo.copyFrom(source);
	}
}
