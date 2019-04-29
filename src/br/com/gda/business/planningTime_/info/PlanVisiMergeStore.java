package br.com.gda.business.planningTime_.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanVisiMergeStore implements InfoMergerVisitorV2<PlanInfo, StoreInfo> {

	@Override public PlanInfo writeRecord(StoreInfo sourceOne, PlanInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceTwo.stores);
		resultInfo.employees.addAll(sourceTwo.employees);
		resultInfo.materials.addAll(sourceTwo.materials);
		resultInfo.weekdays.addAll(sourceTwo.weekdays);
		resultInfo.datas.addAll(sourceTwo.datas);
		
		StoreInfo copyStore = makeCopy(sourceOne);
		resultInfo.stores.add(copyStore);
		
		
		return resultInfo;
	}
	
	
	
	private void checkArgument(StoreInfo sourceOne, PlanInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StoreInfo makeCopy(StoreInfo store) {
		StoreInfo copyStore = new StoreInfo();
		
		copyStore.codOwner = store.codOwner;
		copyStore.codStore = store.codStore;	
//		copyStore.name = store.name;						//TODO: Ajustar
//		copyStore.address1 = store.address1;				//TODO: Ajustar
//		copyStore.address2 = store.address2;				//TODO: Ajustar
//		copyStore.postalCode = store.postalCode;			//TODO: Ajustar
//		copyStore.city = store.city;						//TODO: Ajustar
//		copyStore.codCountry = store.codCountry;			//TODO: Ajustar
//		copyStore.txtCountry = store.txtCountry;			//TODO: Ajustar
//		copyStore.stateProvince = store.stateProvince;		//TODO: Ajustar
//		copyStore.phone = store.phone;						//TODO: Ajustar
		copyStore.codLanguage = store.codLanguage;
		
		return copyStore;
	}



	@Override public boolean shouldWrite(StoreInfo sourceOne, PlanInfo sourceTwo) {
		for (PlanDataInfo eachData : sourceTwo.datas) {
			if (eachData.codOwner <= 0)
				return false;
			
			if (eachData.codOwner != sourceOne.codOwner)
				return false;
		}
		
		
		return true;
	}
}
