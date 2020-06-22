package br.com.mind5.message.emailScheduleCancellation.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmulelInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codCustomer;
	public long codMat;
	public String txtMat;
	public long codEmployee;
	public LocalDate date;
	public LocalTime beginTime;
	public String recipientAddr;
	public String username;		
	public EmabodyInfo bodyData;
	public StolisInfo stolisData;
	public CuslisInfo cuslisData;
	public EmplisInfo emplisData;
	
	
	public EmulelInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codMat = DefaultValue.number();
		codEmployee = DefaultValue.number();
		bodyData = DefaultValue.object();
		stolisData = DefaultValue.object();
		cuslisData = DefaultValue.object();
		emplisData = DefaultValue.object();
	}
	
	
	
	public static EmulelInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmulelInfo.class);
	}
	
	
	
	public static List<EmulelInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmulelInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		EmulelInfo deepCopy = (EmulelInfo) super.clone();
		
		deepCopy.bodyData = CloneUtil.cloneRecord(bodyData, this.getClass());
		deepCopy.stolisData = CloneUtil.cloneRecord(deepCopy.stolisData, this.getClass());
		deepCopy.cuslisData = CloneUtil.cloneRecord(deepCopy.cuslisData, this.getClass());
		deepCopy.emplisData = CloneUtil.cloneRecord(deepCopy.emplisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore    ^ (codStore    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmulelInfo))
			return false;
		
		
		EmulelInfo obj = (EmulelInfo) o;		
		return (codOwner 	== obj.codOwner		&&
				codStore 	== obj.codStore		&&
				codCustomer == obj.codCustomer	&&
				codMat      == obj.codMat		&&
				codEmployee == obj.codEmployee		);
	}	
}
