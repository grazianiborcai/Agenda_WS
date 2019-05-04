package br.com.gda.business.planingData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PlanataSetterWeekday implements InfoSetter<PlanataInfo> {
	
	public PlanataInfo setAttr(PlanataInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodWeekday(recordInfo);
	}
	
	
	
	private void checkArgument(PlanataInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PlanataInfo setCodWeekday(PlanataInfo recordInfo) {
		PlanataInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.codWeekday = enforcedInfo.date.getDayOfWeek().getValue();		
		return enforcedInfo;
	}
	
	
	
	private PlanataInfo makeClone(PlanataInfo recordInfo) {
		try {
			return (PlanataInfo) recordInfo.clone();
			
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
