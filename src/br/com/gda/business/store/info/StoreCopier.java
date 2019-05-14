package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;

public final class StoreCopier {
	public static StoreInfo copyFromOwntore(OwntoreInfo source) {
		InfoCopier<StoreInfo, OwntoreInfo> copier = new StoreCopyOwntore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoreInfo> copyFromOwntore(List<OwntoreInfo> sources) {
		InfoCopier<StoreInfo, OwntoreInfo> copier = new StoreCopyOwntore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<StoreInfo> copyFromPlanime(PlanimeInfo source) {
		InfoCopierOneToMany<StoreInfo, PlanimeInfo> copier = new StoreCopyPlanime();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoreInfo> copyFromPlanime(List<PlanimeInfo> sources) {
		InfoCopierOneToMany<StoreInfo, PlanimeInfo> copier = new StoreCopyPlanime();
		return copier.makeCopy(sources);
	}
}
