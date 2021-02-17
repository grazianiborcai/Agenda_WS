package br.com.mind5.file.fileImageDecorated.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;

public final class FimecoInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPerson;
	public long codMat;
	public long codStore;
	public long codEmployee;
	public long codCustomer;
	public long codUser;
	public long codOwnerRef;
	public FimistInfo fimistCover;
	public List<FimistInfo> fimistes;
	
	public String username;
	
	
	public FimecoInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPerson = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();	
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codOwnerRef = DefaultValue.number();
		fimistCover = DefaultValue.object();
		fimistes = DefaultValue.list();
	}
	
	
	
	public static FimecoInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FimecoInfo.class);
	}
	
	
	
	public static List<FimecoInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FimecoInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		FimecoInfo deepCopy = (FimecoInfo) super.clone();
		
		deepCopy.fimistCover = CloneUtil.cloneRecord(fimistCover, this.getClass());
		deepCopy.fimistes = CloneUtil.cloneRecords(fimistes, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner   	^ (codOwner   	>>> 32));
		result = result * 31 + (int) (codPerson 	^ (codPerson 	>>> 32));
		result = result * 31 + (int) (codMat 		^ (codMat 		>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 	>>> 32));
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	>>> 32));
		result = result * 31 + (int) (codUser 		^ (codUser 		>>> 32));
		result = result * 31 + (int) (codOwnerRef 	^ (codOwnerRef 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FimecoInfo))
			return false;
		
		
		FimecoInfo obj = (FimecoInfo) o;		
		return (codOwner    == obj.codOwner     && 
				codPerson   == obj.codPerson    &&
				codMat    	== obj.codMat   	&&
				codStore    == obj.codStore   	&&
				codEmployee	== obj.codEmployee  &&
				codCustomer == obj.codCustomer  &&
				codUser    	== obj.codUser   	&&
				codOwnerRef == obj.codOwnerRef   	);
	}	
}
