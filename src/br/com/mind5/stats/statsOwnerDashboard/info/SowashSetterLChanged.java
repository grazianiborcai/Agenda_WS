package br.com.mind5.stats.statsOwnerDashboard.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;

public final class SowashSetterLChanged extends InfoSetterTemplate<SowashInfo> {
	
	@Override protected SowashInfo setAttrHook(SowashInfo recordInfo) {
		recordInfo.lastChanged = getMaxFromSowot(recordInfo.sowotes, recordInfo.lastChanged);
		recordInfo.lastChanged = getMaxFromSowus(recordInfo.sowuses, recordInfo.lastChanged);
		recordInfo.lastChanged = getMaxFromSoword(recordInfo.sowordes, recordInfo.lastChanged);
		recordInfo.lastChanged = getMaxFromSowedul(recordInfo.sowedules, recordInfo.lastChanged);
		recordInfo.lastChanged = getMaxFromSowal(recordInfo.sowales, recordInfo.lastChanged);

		return recordInfo;
	}
	
	
	
	private LocalDateTime getMaxFromSowot(List<SowotInfo> sowotes, LocalDateTime maxLastChanged) {
		if (isListEmpty(sowotes))
			return null;
		
		
		for (SowotInfo eachSowot : sowotes) {
			if (maxLastChanged == null) {
				maxLastChanged = eachSowot.lastChanged;
				
			} else if (eachSowot.lastChanged != null) {
				maxLastChanged = ((eachSowot.lastChanged.isAfter(maxLastChanged)) ? eachSowot.lastChanged : maxLastChanged);
			}
		}
		
		
		return maxLastChanged;		
	}
	
	
	
	private LocalDateTime getMaxFromSowus(List<SowusInfo> sowuses, LocalDateTime maxLastChanged) {
		if (isListEmpty(sowuses))
			return null;
		
		
		for (SowusInfo eachSowus : sowuses) {
			if (maxLastChanged == null) {
				maxLastChanged = eachSowus.lastChanged;
				
			} else if (eachSowus.lastChanged != null) {
				maxLastChanged = ((eachSowus.lastChanged.isAfter(maxLastChanged)) ? eachSowus.lastChanged : maxLastChanged);
			}
		}
		
		
		return maxLastChanged;		
	}
	
	
	
	private LocalDateTime getMaxFromSoword(List<SowordInfo> sowordes, LocalDateTime maxLastChanged) {
		if (isListEmpty(sowordes))
			return null;
		
		
		for (SowordInfo eachSoword : sowordes) {
			if (maxLastChanged == null) {
				maxLastChanged = eachSoword.lastChanged;
				
			} else if (eachSoword.lastChanged != null) {
				maxLastChanged = ((eachSoword.lastChanged.isAfter(maxLastChanged)) ? eachSoword.lastChanged : maxLastChanged);
			}
		}
		
		
		return maxLastChanged;		
	}
	
	
	
	private LocalDateTime getMaxFromSowedul(List<SowedulInfo> sowedules, LocalDateTime maxLastChanged) {
		if (isListEmpty(sowedules))
			return null;
		
		
		for (SowedulInfo eachSowedul : sowedules) {
			if (maxLastChanged == null) {
				maxLastChanged = eachSowedul.lastChanged;
				
			} else if (eachSowedul.lastChanged != null) {
				maxLastChanged = ((eachSowedul.lastChanged.isAfter(maxLastChanged)) ? eachSowedul.lastChanged : maxLastChanged);
			}
		}
		
		
		return maxLastChanged;		
	}
	
	
	
	private LocalDateTime getMaxFromSowal(List<SowalInfo> sowales, LocalDateTime maxLastChanged) {
		if (isListEmpty(sowales))
			return null;
		
		
		for (SowalInfo eachSowal : sowales) {
			if (maxLastChanged == null) {
				maxLastChanged = eachSowal.lastChanged;
				
			} else if (eachSowal.lastChanged != null) {
				maxLastChanged = ((eachSowal.lastChanged.isAfter(maxLastChanged)) ? eachSowal.lastChanged : maxLastChanged);
			}
		}
		
		
		return maxLastChanged;		
	}
	
	
	
	private boolean isListEmpty(List<?> records) {
		if (records == null)
			return true;
		
		if (records.isEmpty())
			return true;
		
		return false;
	}
}
