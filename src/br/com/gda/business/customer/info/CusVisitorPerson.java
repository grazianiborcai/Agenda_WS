package br.com.gda.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CusVisitorPerson implements InfoMergerVisitor<CusInfo, PersonInfo, CusInfo> {

	@Override public CusInfo writeRecord(PersonInfo sourceOne, CusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersonInfo sourceOne, CusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusInfo makeClone(CusInfo recordInfo) {
		try {
			return (CusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusInfo merge(PersonInfo sourceOne, CusInfo sourceTwo) {
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
	
	
	
	@Override public boolean shouldWrite(PersonInfo sourceOne, CusInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
