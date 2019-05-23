package br.com.gda.business.employeeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoUniquifyHelper;

final class EmplevateCopyCart extends InfoCopierTemplate<EmplevateInfo, CartInfo>{
	
	public EmplevateCopyCart() {
		super(new InfoUniquifyHelper<EmplevateInfo>());
	}
	
	
	
	@Override protected EmplevateInfo makeCopyHook(CartInfo source) {
		EmplevateInfo result = new EmplevateInfo();
			
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
