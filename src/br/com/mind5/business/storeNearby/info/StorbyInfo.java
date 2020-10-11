package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
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
	public boolean isFavorite;
	public String recordMode;
	public String username;
	public StorextInfo storextData;
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
		isFavorite = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();
		storextData = DefaultValue.object();
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
		
		deepCopy.storextData = CloneUtil.cloneRecord(storextData, this.getClass());
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
		
		if (nameSearch != null)
			result = result * 31 + nameSearch.hashCode();
		
		if (geoHash01 != null)
			result = result * 31 + geoHash01.hashCode();
		
		if (geoHash02 != null)
			result = result * 31 + geoHash02.hashCode();
		
		if (geoHash03 != null)
			result = result * 31 + geoHash03.hashCode();
		
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
				super.isStringEqual(districtSearch, obj.districtSearch) &&
				super.isStringEqual(nameSearch, obj.nameSearch)			&&
				super.isStringEqual(geoHash01, obj.geoHash01)			&&
				super.isStringEqual(geoHash02, obj.geoHash02)			&&
				super.isStringEqual(geoHash03, obj.geoHash03)				);
	}	
}
