package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class AddressCopyCus extends InfoCopierOneToManyTemplate<AddressInfo, CusInfo>{
	
	public AddressCopyCus() {
		super();
	}
	
	
	
	@Override protected List<AddressInfo> makeCopyHook(CusInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<AddressInfo> results = new ArrayList<>();
		
		for (AddressInfo eachRecod : source.addresses) {
			AddressInfo clonedRecord = makeClone(eachRecod);
			results.add(clonedRecord);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(CusInfo source) {
		if (source.addresses == null)
			return false;
		
		if (source.addresses.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
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
