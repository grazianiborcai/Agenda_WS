package br.com.mind5.business.calendarCatalogue.info;

import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class CalgueInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codStore;
	public long codMat;
	public int year;
	public int month;
	public StolisInfo stolisData;
	public MatlisInfo matlisData;
	public List<CalguataInfo> calguatas;
	public List<CalateInfo> calates;
	public List<WeekdayInfo> weekdays;
	public List<DaypartInfo> dayparts;
	public List<MoonaseInfo> moonases;
	public String username;
	
	
	public CalgueInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codMat = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();		
		codStore = DefaultValue.number();
		stolisData = DefaultValue.object();
		matlisData = DefaultValue.object();
		calguatas = DefaultValue.list();
		calates = DefaultValue.list();
		weekdays = DefaultValue.list();
		dayparts = DefaultValue.list();
		moonases = DefaultValue.list();
	}
	
	
	
	public static CalguataInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, CalguataInfo.class);
	}
	
	
	
	public static List<CalguataInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, CalguataInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		CalgueInfo deepCopy = (CalgueInfo) super.clone();
		
		deepCopy.stolisData = CloneUtil.cloneRecord(stolisData, this.getClass());
		deepCopy.matlisData = CloneUtil.cloneRecord(matlisData, this.getClass());		
		deepCopy.calguatas  = CloneUtil.cloneRecords(calguatas, this.getClass());
		deepCopy.calates    = CloneUtil.cloneRecords(calates, this.getClass());
		deepCopy.weekdays   = CloneUtil.cloneRecords(weekdays, this.getClass());
		deepCopy.dayparts   = CloneUtil.cloneRecords(dayparts, this.getClass());
		deepCopy.moonases   = CloneUtil.cloneRecords(moonases, this.getClass());
		
		return deepCopy;
	}  
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CalguataInfo))
			return false;
		
		
		CalguataInfo obj = (CalguataInfo) o;		
		
		return (codOwner 	 == obj.codOwner 	&& 
				codStore 	 == obj.codStore 	&& 
				codMat 		 == obj.codMat);
	}
}
