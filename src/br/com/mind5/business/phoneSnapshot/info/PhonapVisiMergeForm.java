package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhonapVisiMergeForm implements InfoMergerVisitor_<PhonapInfo, FormoneInfo> {

	@Override public PhonapInfo writeRecord(FormoneInfo sourceOne, PhonapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FormoneInfo sourceOne, PhonapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhonapInfo merge(FormoneInfo sourceOne, PhonapInfo sourceTwo) {
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
		
		SystemLog.logError(this.getClass(), e);
	}


	
	@Override public boolean shouldWrite(FormoneInfo sourceOne, PhonapInfo sourceTwo) {
		return sourceOne.codCountry.equals(sourceTwo.codCountry);
	}
}
