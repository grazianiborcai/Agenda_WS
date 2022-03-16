package br.com.mind5.stats.statsOwnerDashboard.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;

public final class SowashInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public List<SowotInfo> sowotes;
	public List<SowusInfo> sowuses;
	public List<SowordInfo> sowordes;
	public List<SowedulInfo> sowedules;
	public List<SowalInfo> sowales;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SowashInfo() {
		super();
		
		codOwner = DefaultValue.number();
		sowotes = DefaultValue.list();
		sowuses = DefaultValue.list();
		sowordes = DefaultValue.list();
		sowedules = DefaultValue.list();
		sowales = DefaultValue.list();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SowashInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowashInfo.class);
	}
	
	
	
	public static List<SowashInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowashInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SowashInfo deepCopy = (SowashInfo) super.clone();
		
		deepCopy.sowotes = CloneUtil.cloneRecords(sowotes, this.getClass());
		deepCopy.sowuses = CloneUtil.cloneRecords(sowuses, this.getClass());
		deepCopy.sowordes = CloneUtil.cloneRecords(sowordes, this.getClass());
		deepCopy.sowedules = CloneUtil.cloneRecords(sowedules, this.getClass());
		deepCopy.sowales = CloneUtil.cloneRecords(sowales, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		if (sowotes != null)
			result = result * 31 + sowotes.hashCode();
		
		if (sowuses != null)
			result = result * 31 + sowuses.hashCode();
		
		if (sowordes != null)
			result = result * 31 + sowordes.hashCode();
		
		if (sowedules != null)
			result = result * 31 + sowedules.hashCode();
		
		if (sowales != null)
			result = result * 31 + sowales.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SowashInfo))
			return false;
		
		
		SowashInfo obj = (SowashInfo) o;
		return (codOwner == obj.codOwner && 
				super.isListEqual(sowotes  , obj.sowotes  ) &&
				super.isListEqual(sowuses  , obj.sowuses  ) &&
				super.isListEqual(sowordes , obj.sowordes ) &&
				super.isListEqual(sowedules, obj.sowedules) &&
				super.isListEqual(sowales  , obj.sowales  ));
	}
}
