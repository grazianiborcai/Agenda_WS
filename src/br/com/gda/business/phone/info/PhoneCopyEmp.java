package br.com.gda.business.phone.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class PhoneCopyEmp extends InfoCopierOneToManyTemplate<PhoneInfo, EmpInfo>{
	
	public PhoneCopyEmp() {
		super();
	}
	
	
	
	@Override protected List<PhoneInfo> makeCopyHook(EmpInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<PhoneInfo> results = new ArrayList<>();
		
		for (PhoneInfo eachRecod : source.phones) {
			PhoneInfo clonedRecord = makeClone(eachRecod);
			results.add(clonedRecord);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(EmpInfo source) {
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
