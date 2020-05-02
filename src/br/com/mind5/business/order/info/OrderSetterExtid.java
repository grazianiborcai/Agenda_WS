package br.com.mind5.business.order.info;

import java.time.format.DateTimeFormatter;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterExtid extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {		
		recordInfo.codOrderExt = genExtId();
		return recordInfo;
	}
	
	
	
	private String genExtId() {
		StringBuilder result = new StringBuilder();
		String now = getClockTime();
		
		result.append(shuffle(0, now));
		result.append(shuffle(1, now));
		
		return mask(result.toString());
	}
	
	
	
	private String getClockTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
		return DefaultValue.localDateTimeNow().format(formatter);
	}
	
	
	
	private String shuffle(int beginIndex, String toShuffle) {
		StringBuilder result = new StringBuilder();
		int i = beginIndex;
		
		do {			
			result.append(toShuffle.charAt(i));
			i=i+2;
			
		} while (i < toShuffle.length());
		
		return result.toString();
	}
	
	
	
	private String mask(String toMask) {
		StringBuilder result = new StringBuilder();
		
		for (int i=0; i < toMask.length(); i++) {
			result.append(maskChar(i, toMask.charAt(i)));
		}
		
		return result.toString();
	}
	
	
	
	private String maskChar(int index, char toMask) {
		String result = Character.toString(toMask);
		
		if (index >= 0 && index <= 2)
			result = Character.toString((char)('A' + Character.getNumericValue(toMask)));
		
		if (index == 3 || index == 9)
			result = "-" + result;
			
		return result;
	}
}
