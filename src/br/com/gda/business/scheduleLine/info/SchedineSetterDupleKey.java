package br.com.gda.business.scheduleLine.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class SchedineSetterDupleKey implements InfoSetter<SchedineInfo> {
	
	public SchedineInfo setAttr(SchedineInfo recordInfo) {
		checkArgument(recordInfo);
		return setDupleKey(recordInfo);
	}
	
	
	
	private void checkArgument(SchedineInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedineInfo setDupleKey(SchedineInfo recordInfo) {
		SchedineInfo enforcedInfo = new SchedineInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codMat = recordInfo.codMat;
		enforcedInfo.codStore = recordInfo.codStore;
		enforcedInfo.codEmployee = recordInfo.codEmployee;
		enforcedInfo.date = recordInfo.date;
		enforcedInfo.beginTime = recordInfo.beginTime;
		enforcedInfo.endTime = recordInfo.endTime;
		enforcedInfo.username = recordInfo.username;
		
		return enforcedInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
