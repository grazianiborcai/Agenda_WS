package br.com.mind5.business.planingData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.Daypart;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PlanataSetterDaypart implements InfoSetter<PlanataInfo> {
	
	public PlanataInfo setAttr(PlanataInfo recordInfo) {
		checkArgument(recordInfo);
		
		if (recordInfo.beginTime != null)
			recordInfo.codDaypart = Daypart.of(recordInfo.beginTime).getCodDaypart();
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(PlanataInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
