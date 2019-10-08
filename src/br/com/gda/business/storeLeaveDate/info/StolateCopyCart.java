package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoUniquifyHelper;

final class StolateCopyCart extends InfoCopierTemplate<StolateInfo, CartemInfo>{
	
	public StolateCopyCart() {
		super(new InfoUniquifyHelper<StolateInfo>());
	}
	
	
	
	@Override protected StolateInfo makeCopyHook(CartemInfo source) {
		StolateInfo result = new StolateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.dateValidFrom = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		result.dateValidTo = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());		
		result.timeValidFrom = LocalTime.of(source.beginTime.getHour(), source.beginTime.getMinute());
		result.timeValidTo = LocalTime.of(source.endTime.getHour(), source.endTime.getMinute());
		return result;
	}
}
