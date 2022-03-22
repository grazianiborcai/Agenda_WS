package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CustamonSetterAddressDefault extends InfoSetterTemplate<CustamonInfo> {
	
	@Override protected CustamonInfo setAttrHook(CustamonInfo recordInfo) {
		recordInfo.codCountry = "N/A";
		recordInfo.txtCountry = "N/A";
		recordInfo.codState 	= "N/A";
		recordInfo.txtState 	= "N/A";
		recordInfo.city 		= "N/A";

		return recordInfo;
	}
}
