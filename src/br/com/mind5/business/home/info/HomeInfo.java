package br.com.mind5.business.home.info;

import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.security.userHome.info.UsomeInfo;

public final class HomeInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codUser;
	public CartouInfo cartou;
	public UsomeInfo usome;
	public String username;
	
	
	public HomeInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codUser = DefaultValue.number();
		cartou = DefaultValue.object();
		usome = DefaultValue.object();
	}
	
	
	
	public static HomeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, HomeInfo.class);
	}
	
	
	
	public static List<HomeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, HomeInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		HomeInfo deepCopy = (HomeInfo) super.clone();
		
		deepCopy.cartou = CloneUtil.cloneRecord(cartou, this.getClass());
		deepCopy.usome = CloneUtil.cloneRecord(usome, this.getClass());
		
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
