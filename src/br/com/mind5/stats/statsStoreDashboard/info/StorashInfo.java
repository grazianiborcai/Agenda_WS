package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;

public final class StorashInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String calmonth;
	public StedmonInfo stedmonData;
	public List<SteddInfo> steddes;
	public List<StedmonInfo> stedmones;
	public List<StordInfo> stordes;
	public List<StoronInfo> storones;
	public String username;
	
	
	public StorashInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		stedmonData = DefaultValue.object();
		steddes = DefaultValue.list();
		stedmones = DefaultValue.list();
		stordes = DefaultValue.list();
		storones = DefaultValue.list();
	}
	
	
	
	public static StorashInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorashInfo.class);
	}
	
	
	
	public static List<StorashInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorashInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StorashInfo deepCopy = (StorashInfo) super.clone();
		
		deepCopy.stedmonData = CloneUtil.cloneRecord (stedmonData, this.getClass());
		deepCopy.steddes   	 = CloneUtil.cloneRecords(steddes    , this.getClass());
		deepCopy.stedmones 	 = CloneUtil.cloneRecords(stedmones  , this.getClass());
		deepCopy.stordes   	 = CloneUtil.cloneRecords(stordes    , this.getClass());
		deepCopy.storones  	 = CloneUtil.cloneRecords(storones   , this.getClass());
		
		return deepCopy;
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
		
		
		if (!(o instanceof StorashInfo))
			return false;
		
		
		StorashInfo obj = (StorashInfo) o;
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				super.isStringEqual(calmonth, obj.calmonth));
	}
}
