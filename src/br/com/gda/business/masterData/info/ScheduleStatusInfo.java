package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class ScheduleStatusInfo extends InfoRecord implements Cloneable {
	public String codScheduleStatus;
	public String txtScheduleStatus;
	public String codLanguage;
	
	
	public ScheduleStatusInfo() {
		this.codLanguage = DefaultValue.language();
	}
	
	
	
	public static ScheduleStatusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, ScheduleStatusInfo.class);
	}
	
	
	
	public static List<ScheduleStatusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, ScheduleStatusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		if (codScheduleStatus == null)
			return 0;
		
		return codScheduleStatus.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof ScheduleStatusInfo))
			return false;
		
		
		ScheduleStatusInfo obj = (ScheduleStatusInfo) o;		
		return (isStringEqual(codScheduleStatus, obj.codScheduleStatus));
	}
}
