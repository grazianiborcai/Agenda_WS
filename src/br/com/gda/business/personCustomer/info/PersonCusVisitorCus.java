package br.com.gda.business.personCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class PersonCusVisitorCus implements InfoMergerVisitor_<PersonCusInfo, CusInfo, PersonCusInfo> {

	@Override public PersonCusInfo writeRecord(CusInfo sourceOne, PersonCusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PersonCusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusInfo sourceOne, PersonCusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PersonCusInfo makeClone(PersonCusInfo recordInfo) {
		try {
			return (PersonCusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PersonCusInfo merge(CusInfo sourceOne, PersonCusInfo sourceTwo) {
		sourceTwo.codCustomer = sourceOne.codCustomer;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CusInfo sourceOne, PersonCusInfo sourceTwo) {
		return (sourceOne.codOwner  	== sourceTwo.codOwner 		&& 
				sourceOne.codPerson 	== sourceTwo.codPerson		&&
				sourceOne.codCustomer   == sourceTwo.codCustomer		);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
