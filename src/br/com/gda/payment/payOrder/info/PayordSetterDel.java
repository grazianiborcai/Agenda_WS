package br.com.gda.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.RecordMode;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PayordSetterDel implements InfoSetter<PayordInfo> {
	
	public PayordInfo setAttr(PayordInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodDel(recordInfo);
	}
	
	
	
	private void checkArgument(PayordInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PayordInfo setCodDel(PayordInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
