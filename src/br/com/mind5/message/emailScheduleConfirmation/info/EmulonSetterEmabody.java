package br.com.mind5.message.emailScheduleConfirmation.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmulonSetterEmabody extends InfoSetterTemplate<EmulonInfo> {
	
	@Override protected EmulonInfo setAttrHook(EmulonInfo recordInfo) {	
		recordInfo.bodyData = new EmabodyInfo();
		
		recordInfo.recipientAddr = recordInfo.cuslisData.persolisData.email;
		recordInfo.bodyData.codLanguage = recordInfo.codLanguage;		
		recordInfo.bodyData.username = recordInfo.username;			
		recordInfo.bodyData.param01 = recordInfo.cuslisData.persolisData.name;
		recordInfo.bodyData.param02 = dateToString(recordInfo.date);
		recordInfo.bodyData.param03 = timeToString(recordInfo.beginTime);
		recordInfo.bodyData.param04 = recordInfo.txtMat;
		recordInfo.bodyData.param05 = recordInfo.emplisData.persolisData.name;
		recordInfo.bodyData.param06 = recordInfo.stolisData.complisData.name;
		recordInfo.bodyData.param07 = firstAddressToString(recordInfo.stolisData);
		
		return recordInfo;
	}
	
	
	
	private String dateToString(LocalDate date) {
		String pattern = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return formatter.format(date);
	}
	
	
	
	private String timeToString(LocalTime time) {
		String pattern = "HH:mm";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return formatter.format(time);
	}
	
	
	
	private String firstAddressToString(StolisInfo stolis) {
		if (stolis.addressData == null)
			return "";

		String result = stolis.addressData.street + " - " + stolis.addressData.streetNumber;
		
		if (stolis.addressData.complement != null)
			result = result + " - " + stolis.addressData.complement;
		
		if (stolis.addressData.district != null)
			result = result + " - " + stolis.addressData.district;
		
		result = result + " - " + stolis.addressData.city;
		result = result + " - " + stolis.addressData.txtState;
		
		return result;
	}
}
