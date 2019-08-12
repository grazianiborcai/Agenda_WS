package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoCopierTemplate;

final class OrderemCopyCartem extends InfoCopierTemplate<SchedineInfo, CartemInfo>{
	
	public OrderemCopyCartem() {
		super();
	}
	
	
	
	@Override protected SchedineInfo makeCopyHook(CartemInfo source) {
		return SchedineInfo.copyFrom(source);
	}
}
