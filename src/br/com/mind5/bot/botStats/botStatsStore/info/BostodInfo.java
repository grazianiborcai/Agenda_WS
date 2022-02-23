package br.com.mind5.bot.botStats.botStatsStore.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BostodInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String calmonth;
	public int year;
	public int month;
	public String txtMonth;
	public String username;
	
	
	public BostodInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
	}
	
	
	
	public static BostodInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BostodInfo.class);
	}
	
	
	
	public static List<BostodInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BostodInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		if (calmonth != null)
			result = result * 31 + calmonth.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BostodInfo))
			return false;
		
		
		BostodInfo obj = (BostodInfo) o;		
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				super.isStringEqual(calmonth, obj.calmonth));
	}
}
