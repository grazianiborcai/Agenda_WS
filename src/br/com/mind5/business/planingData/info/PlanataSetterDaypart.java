package br.com.mind5.business.planingData.info;

import br.com.mind5.business.masterData.info.common.Daypart;
import br.com.mind5.common.SystemLog;
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
		
		SystemLog.logError(this.getClass(), e);
	}	
}
