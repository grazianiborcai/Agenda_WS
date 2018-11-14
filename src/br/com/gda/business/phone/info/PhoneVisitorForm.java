package br.com.gda.business.phone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PhoneVisitorForm implements InfoMergerVisitor<PhoneInfo, FormPhoneInfo, PhoneInfo> {

	@Override public PhoneInfo writeRecord(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		if (sourceOne.codCountry.equals(sourceTwo.codCountry) == false) {
			logException(new IllegalArgumentException("codCountry" + SystemMessage.ARGUMENT_DONT_MATCH));
			throw new IllegalArgumentException("codCountry" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
	
	
	
	private PhoneInfo merge(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		PhoneInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codForm = sourceOne.codForm;
		
		return resultInfo;
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
