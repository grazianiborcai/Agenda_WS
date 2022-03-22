package br.com.mind5.bot.botStats.botStatsCustomer.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BostusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public String calmonth;
	public int year;
	public int month;
	public String txtMonth;
	public String username;
	
	
	public BostusInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
	}
	
	
	
	public static BostusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BostusInfo.class);
	}
	
	
	
	public static List<BostusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BostusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		
		if (calmonth != null)
			result = result * 31 + calmonth.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BostusInfo))
			return false;
		
		
		BostusInfo obj = (BostusInfo) o;		
		return (codOwner == obj.codOwner &&
				codCustomer == obj.codCustomer &&
				super.isStringEqual(calmonth, obj.calmonth));
	}
}
