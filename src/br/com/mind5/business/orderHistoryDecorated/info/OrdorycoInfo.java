package br.com.mind5.business.orderHistoryDecorated.info;

import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;

public final class OrdorycoInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public int postingYear;
	public int postingYearMonth;
	public String codOrderStatus;
	public String username;
	public List<OrdoryInfo> ordorys;
	public List<StusoryInfo> stusorys;
	
	
	public OrdorycoInfo() {
		super();
		
		codOwner = DefaultValue.number();				
		codUser = DefaultValue.number();
		postingYear = DefaultValue.number();
		postingYearMonth = DefaultValue.number();
		ordorys = DefaultValue.list();
		stusorys = DefaultValue.list();
	}
	
	
	
	public static OrdorycoInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdorycoInfo.class);
	}
	
	
	
	public static List<OrdorycoInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdorycoInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrdorycoInfo deepCopy = (OrdorycoInfo) super.clone();
		
		deepCopy.ordorys = CloneUtil.cloneRecords(ordorys, this.getClass());
		deepCopy.stusorys = CloneUtil.cloneRecords(stusorys, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner         ^ (codOwner         >>> 32));
		result = result * 31 + (int) (codUser          ^ (codUser          >>> 32));
		result = result * 31 + (int) (postingYear      ^ (postingYear      >>> 32));
		result = result * 31 + (int) (postingYearMonth ^ (postingYearMonth >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdorycoInfo))
			return false;
		
		
		OrdorycoInfo obj = (OrdorycoInfo) o;		
		return (codOwner         == obj.codOwner 	&& 
				codUser          == obj.codUser		&&
				postingYear      == obj.postingYear &&
				postingYearMonth == obj.postingYearMonth);
	}
}
