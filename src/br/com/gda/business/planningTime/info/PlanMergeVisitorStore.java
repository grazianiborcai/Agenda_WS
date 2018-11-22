package br.com.gda.business.planningTime.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanMergeVisitorStore implements InfoMergerVisitor<PlanInfo, PlanInfo, StoreInfo> {

	@Override public PlanInfo writeRecord(PlanInfo sourceOne, StoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		resultInfo.datas.addAll(sourceOne.datas);
		
		StoreInfo copyStore = makeCopy(sourceTwo);
		resultInfo.stores.add(copyStore);
		
		
		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, StoreInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StoreInfo makeCopy(StoreInfo store) {
		StoreInfo copyStore = new StoreInfo();
		
		copyStore.codOwner = store.codOwner;
		copyStore.codStore = store.codStore;	
		copyStore.name = store.name;
		copyStore.address1 = store.address1;
		copyStore.address2 = store.address2;
		copyStore.postalCode = store.postalCode;
		copyStore.city = store.city;
		copyStore.codCountry = store.codCountry;
		copyStore.txtCountry = store.txtCountry;
		copyStore.stateProvince = store.stateProvince;
		copyStore.phone = store.phone;
		copyStore.codLanguage = store.codLanguage;
		
		return copyStore;
	}



	@Override public boolean shouldWrite(PlanInfo sourceOne, StoreInfo sourceTwo) {
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				return false;
			
			if (eachData.codOwner != sourceTwo.codOwner)
				return false;
		}
		
		
		return true;
	}
}
