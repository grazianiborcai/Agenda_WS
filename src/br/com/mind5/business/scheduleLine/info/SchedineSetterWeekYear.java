package br.com.mind5.business.scheduleLine.info;

import java.time.format.DateTimeFormatter;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterWeekYear extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("w");
		recordInfo.weekYear = Integer.valueOf(formatter.format(recordInfo.date));
		
		return recordInfo;
	}
}
