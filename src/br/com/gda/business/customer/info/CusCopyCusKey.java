package br.com.gda.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoSetter;

final class CusCopyCusKey extends InfoCopierTemplate<CusInfo, CusInfo>{
	
	public CusCopyCusKey() {
		super();
	}
	
	
	
	@Override protected CusInfo makeCopyHook(CusInfo source) {
		CusInfo result = makeClone(source);
		
		InfoSetter<CusInfo> setterKey = new CusSetterKey();
		result = setterKey.setAttr(result);

		return result;
	}
	
	
	
	private CusInfo makeClone(CusInfo recordInfo) {
		try {
			return (CusInfo) recordInfo.clone();
			
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
