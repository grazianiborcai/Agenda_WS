package br.com.gda.business.planningTime_.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PlanSetterCodWeekday implements InfoSetter<PlanInfo> {
	
	public PlanInfo setAttr(PlanInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodWeekday(recordInfo);
	}
	
	
	
	private void checkArgument(PlanInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PlanInfo setCodWeekday(PlanInfo recordInfo) {
		PlanInfo enforcedInfo = makeClone(recordInfo);
		
		for (PlanDataInfo eachData: enforcedInfo.datas) {
			eachData.codWeekday = eachData.date.getDayOfWeek().getValue();
		}
		
		return enforcedInfo;
	}
	
	
	
	private PlanInfo makeClone(PlanInfo recordInfo) {
		try {
			return (PlanInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
