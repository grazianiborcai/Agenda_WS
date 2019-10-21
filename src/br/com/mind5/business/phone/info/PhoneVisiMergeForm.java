package br.com.mind5.business.phone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class PhoneVisiMergeForm implements InfoMergerVisitor<PhoneInfo, FormPhoneInfo> {

	@Override public PhoneInfo writeRecord(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
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


	
	@Override public boolean shouldWrite(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		return sourceOne.codCountry.equals(sourceTwo.codCountry);
	}
}
