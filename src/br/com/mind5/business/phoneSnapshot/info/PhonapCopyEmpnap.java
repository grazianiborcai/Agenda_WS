package br.com.mind5.business.phoneSnapshot.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class PhonapCopyEmpnap extends InfoCopierOneToManyTemplate<PhonapInfo, EmpnapInfo> {
	
	public PhonapCopyEmpnap() {
		super();
	}
	
	
	
	@Override protected List<PhonapInfo> makeCopyHook(EmpnapInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<PhonapInfo> results = new ArrayList<>();
		
		for (PhonapInfo eachRecod : source.phonaps) {
			PhonapInfo clonedRecord = PhonapInfo.copyFrom(eachRecod);
			results.add(clonedRecord);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(EmpnapInfo source) {
		if (source.addresnaps == null)
			return false;
		
		if (source.addresnaps.isEmpty())
			return false;
		
		return true;
	}
}
