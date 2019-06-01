package br.com.gda.business.orderItem.info;

import java.time.format.DateTimeFormatter;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrderSetterExtid implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo order) {
		checkArgument(order);
		
		order.codOrderExt = genExtId();
		return order;
	}
	
	
	
	private void checkArgument(OrderInfo order) {
		if (order == null)
			throw new NullPointerException("order" + SystemMessage.NULL_ARGUMENT);
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
