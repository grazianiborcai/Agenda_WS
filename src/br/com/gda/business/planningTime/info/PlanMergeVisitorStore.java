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
