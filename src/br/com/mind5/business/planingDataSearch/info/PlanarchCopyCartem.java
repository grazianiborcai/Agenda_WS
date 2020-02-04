package br.com.mind5.business.planingDataSearch.info;


import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PlanarchCopyCartem extends InfoCopierTemplate<PlanarchInfo, CartemInfo>{
	
	public PlanarchCopyCartem() {
		super();
	}
	
	
	
	@Override protected PlanarchInfo makeCopyHook(CartemInfo source) {
		PlanarchInfo result = PlanarchInfo.copyFrom(source);		
		result.beginTimeSel = result.beginTime;
		result.endTimeSel = result.endTime;

		return result;
	}
}
