package br.com.mind5.business.scheduleLine.info;

import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedineSetterWeekYear implements InfoSetter<SchedineInfo> {
	
	public SchedineInfo setAttr(SchedineInfo recordInfo) {
		checkArgument(recordInfo);
		return setDay(recordInfo);
	}
	
	
	
	private void checkArgument(SchedineInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedineInfo setDay(SchedineInfo recordInfo) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("w");
		recordInfo.weekYear = Integer.valueOf(formatter.format(recordInfo.date));
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
