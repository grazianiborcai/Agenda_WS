package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class AddresnapCopyEmpnap extends InfoCopierOneToManyTemplate<AddresnapInfo, EmpnapInfo>{
	
	public AddresnapCopyEmpnap() {
		super();
	}
	
	
	
	@Override protected List<AddresnapInfo> makeCopyHook(EmpnapInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<AddresnapInfo> results = new ArrayList<>();
		
		for (AddresnapInfo eachRecod : source.addresnaps) {
			AddresnapInfo clonedRecord = AddresnapInfo.copyFrom(eachRecod);
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
