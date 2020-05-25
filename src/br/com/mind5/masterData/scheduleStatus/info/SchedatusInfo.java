package br.com.mind5.masterData.scheduleStatus.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class SchedatusInfo extends InfoRecord implements Cloneable {
	public String codScheduleStatus;
	public String txtScheduleStatus;
	
	
	public SchedatusInfo() {
		super();
	}
	
	
	
	public static SchedatusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedatusInfo.class);
	}
	
	
	
	public static List<SchedatusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedatusInfo.class);
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
		
		
		if (!(o instanceof SchedatusInfo))
			return false;
		
		
		SchedatusInfo obj = (SchedatusInfo) o;		
		return (isStringEqual(codScheduleStatus, obj.codScheduleStatus));
	}
}
