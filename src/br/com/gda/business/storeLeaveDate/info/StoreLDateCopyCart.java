package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoUniquifyHelper;

final class StoreLDateCopyCart extends InfoCopierTemplate<StoreLDateInfo, CartInfo>{
	
	public StoreLDateCopyCart() {
		super(new InfoUniquifyHelper<StoreLDateInfo>());
	}
	
	
	
	@Override protected StoreLDateInfo makeCopyHook(CartInfo source) {
		StoreLDateInfo result = new StoreLDateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.dateValidFrom = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		result.dateValidTo = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());		
		result.timeValidFrom = LocalTime.of(source.beginTime.getHour(), source.beginTime.getMinute());
		result.timeValidTo = LocalTime.of(source.endTime.getHour(), source.endTime.getMinute());
		return result;
	}
}
