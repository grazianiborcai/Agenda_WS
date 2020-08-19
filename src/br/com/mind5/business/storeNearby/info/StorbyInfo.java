package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;

public final class StorbyInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codCompany;
	public String districtSearch;
	public String nameSearch;
	public float longitude;
	public float latitude;
	public String geoHash01;
	public String geoHash02;
	public String geoHash03;
	public double distanceKm;
	public String recordMode;
	public String username;
	public AddressInfo addressData;
	public ComplisInfo complisData;
	public List<FimistInfo> fimistes;
	public List<MatoporeInfo> matopores;
	
	
	public StorbyInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codCompany = DefaultValue.number();
		longitude = DefaultValue.geo();
		latitude = DefaultValue.geo();
		distanceKm = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		complisData = DefaultValue.object();
		addressData = DefaultValue.object();
		fimistes = DefaultValue.list();
		matopores = DefaultValue.list();
	}
	
	
	
	public static StorbyInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorbyInfo.class);
	}
	
	
	
	public static List<StorbyInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorbyInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StorbyInfo deepCopy = (StorbyInfo) super.clone();
		
		deepCopy.fimistes = CloneUtil.cloneRecords(fimistes, this.getClass());
		deepCopy.addressData = CloneUtil.cloneRecord(addressData, this.getClass());
		deepCopy.complisData = CloneUtil.cloneRecord(complisData, this.getClass());
		deepCopy.matopores = CloneUtil.cloneRecords(matopores, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		if (districtSearch != null)
			result = result * 31 + districtSearch.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StorbyInfo))
			return false;
		
		
		StorbyInfo obj = (StorbyInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				super.isStringEqual(districtSearch, obj.districtSearch));
	}	
}
