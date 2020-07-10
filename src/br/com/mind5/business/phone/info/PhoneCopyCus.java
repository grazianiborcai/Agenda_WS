package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class PhoneCopyCus extends InfoCopierOneToManyTemplate<PhoneInfo, CusInfo> {
	
	public PhoneCopyCus() {
		super();
	}
	
	
	
	@Override protected List<PhoneInfo> makeCopyHook(CusInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<PhoneInfo> results = new ArrayList<>();
		
		for (PhoneInfo eachRecod : source.phones) {
			PhoneInfo clonedRecord = makeClone(eachRecod);
			results.add(clonedRecord);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(CusInfo source) {
		if (source.phones == null)
			return false;
		
		if (source.phones.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private PhoneInfo makeClone(PhoneInfo recordInfo) {
		try {
			return (PhoneInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
