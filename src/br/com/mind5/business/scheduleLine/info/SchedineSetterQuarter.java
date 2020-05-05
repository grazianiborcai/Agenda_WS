package br.com.mind5.business.scheduleLine.info;

import java.time.format.DateTimeFormatter;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterQuarter extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Q");
		recordInfo.quarter = Integer.valueOf(formatter.format(recordInfo.date));
		
		return recordInfo;
	}
}
