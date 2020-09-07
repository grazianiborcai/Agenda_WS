package br.com.mind5.business.calendarCatalogue.info;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class CalgueSetterAvailable extends InfoSetterTemplate<CalgueInfo> {
	
	@Override protected CalgueInfo setAttrHook(CalgueInfo recordInfo) {
		for (CalatityInfo eachCalatity : recordInfo.calatitys) {
			eachCalatity.isAvailable = false;
			
			for (CalguataInfo eachCalguata : recordInfo.calguatas) {
				if (eachCalatity.date.equals(eachCalguata.date)) {
					eachCalatity.isAvailable = true;
				}
			}
		}
		

		return recordInfo;
	}
}
