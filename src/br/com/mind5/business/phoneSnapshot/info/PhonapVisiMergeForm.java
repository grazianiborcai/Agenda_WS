package br.com.mind5.business.phoneSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhonapVisiMergeForm implements InfoMergerVisitor_<PhonapInfo, FormPhoneInfo> {

	@Override public PhonapInfo writeRecord(FormPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FormPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhonapInfo merge(FormPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		PhonapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codForm = sourceOne.codForm;
		
		return resultInfo;
	}
	
	
	
	private PhonapInfo makeClone(PhonapInfo recordInfo) {
		try {
			return (PhonapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}


	
	@Override public boolean shouldWrite(FormPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		return sourceOne.codCountry.equals(sourceTwo.codCountry);
	}
}
