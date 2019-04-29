package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class PaycusVisiPerson implements InfoMergerVisitor_<PaycusInfo, PersonInfo, PaycusInfo> {

	@Override public PaycusInfo writeRecord(PersonInfo sourceOne, PaycusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaycusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonInfo sourceOne, PaycusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PaycusInfo makeClone(PaycusInfo recordInfo) {
		try {
			return (PaycusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PaycusInfo merge(PersonInfo sourceOne, PaycusInfo sourceTwo) {
		sourceTwo.codPerson = sourceOne.codPerson;
		sourceTwo.cpf = sourceOne.cpf;
		sourceTwo.name = sourceOne.name;
		sourceTwo.codGender = sourceOne.codGender;
		sourceTwo.txtGender = sourceOne.txtGender;
		sourceTwo.codEntityCateg = sourceOne.codEntityCateg;
		sourceTwo.birthDate = sourceOne.birthDate;
		sourceTwo.email = sourceOne.email;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonInfo sourceOne, PaycusInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
