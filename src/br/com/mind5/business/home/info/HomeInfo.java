package br.com.mind5.business.home.info;

import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.security.userHome.info.UsomeInfo;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;

public final class HomeInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codUser;
	public CartouInfo cartouData;
	public StoprosouInfo stoprosouData;
	public UsomeInfo usomeData;
	public List<StomanInfo> stomanes;
	public SowashInfo sowashData;
	public StorashInfo storashData;
	public String username;
	
	
	public HomeInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codUser = DefaultValue.number();
		cartouData = DefaultValue.object();
		stoprosouData = DefaultValue.object();
		usomeData = DefaultValue.object();
		sowashData = DefaultValue.object();
		storashData = DefaultValue.object();
		stomanes = DefaultValue.list();
	}
	
	
	
	public static HomeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, HomeInfo.class);
	}
	
	
	
	public static List<HomeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, HomeInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		HomeInfo deepCopy = (HomeInfo) super.clone();
		
		deepCopy.cartouData    = CloneUtil.cloneRecord (cartouData   , this.getClass());
		deepCopy.stoprosouData = CloneUtil.cloneRecord (stoprosouData, this.getClass());
		deepCopy.usomeData     = CloneUtil.cloneRecord (usomeData    , this.getClass());
		deepCopy.sowashData    = CloneUtil.cloneRecord (sowashData   , this.getClass());
		deepCopy.storashData   = CloneUtil.cloneRecord (storashData  , this.getClass());
		deepCopy.stomanes      = CloneUtil.cloneRecords(stomanes     , this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codUser 	  ^ (codUser 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof HomeInfo))
			return false;
		
		
		HomeInfo obj = (HomeInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codUser     == obj.codUser			);
	}
}
