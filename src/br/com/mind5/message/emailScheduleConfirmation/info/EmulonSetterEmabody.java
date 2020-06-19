package br.com.mind5.message.emailScheduleConfirmation.info;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.mind5.business.address.info.AddressInfo;
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
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	
	
	private String timeToString(LocalTime time) {
		return String.valueOf(time.getHour()) + ":" + String.valueOf(time.getMinute());
	}
	
	
	
	private String firstAddressToString(StolisInfo stolis) {
		if (stolis.addresses == null)
			return "";
		
		if (stolis.addresses.isEmpty())
			return "";
		
		AddressInfo firstAddress = stolis.addresses.get(0);
		
		String result = firstAddress.street + " - " + firstAddress.streetNumber;
		
		if (firstAddress.complement != null)
			result = result + " - " + firstAddress.complement;
		
		if (firstAddress.district != null)
			result = result + " - " + firstAddress.district;
		
		result = result + " - " + firstAddress.city;
		result = result + " - " + firstAddress.txtState;
		
		return result;
	}
}
