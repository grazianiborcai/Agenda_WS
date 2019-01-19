package br.com.gda.business.address.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

final class AddressCopyPayCus extends InfoCopierTemplate<AddressInfo, PaycusInfo>{
	
	public AddressCopyPayCus() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(PaycusInfo source) {
		if (source.address == null)
			return null;
		
		AddressInfo result = makeClone(source.address);
		return result;
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
