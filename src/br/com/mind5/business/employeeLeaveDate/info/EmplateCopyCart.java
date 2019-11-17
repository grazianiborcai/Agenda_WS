package br.com.mind5.business.employeeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.info.InfoUniquifyHelper;

final class EmplateCopyCart extends InfoCopierTemplate<EmplateInfo, CartemInfo>{
	
	public EmplateCopyCart() {
		super(new InfoUniquifyHelper<EmplateInfo>());
	}
	
	
	
	@Override protected EmplateInfo makeCopyHook(CartemInfo source) {
		EmplateInfo result = new EmplateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.dateValidFrom = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		result.dateValidTo = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());		
		result.timeValidFrom = LocalTime.of(source.beginTime.getHour(), source.beginTime.getMinute());
		result.timeValidTo = LocalTime.of(source.endTime.getHour(), source.endTime.getMinute());
		return result;
	}
}
