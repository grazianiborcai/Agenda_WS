package br.com.gda.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class AddresnapCopyEmpnap extends InfoCopierOneToManyTemplate<AddresnapInfo, EmpnapInfo>{
	
	public AddresnapCopyEmpnap() {
		super();
	}
	
	
	
	@Override protected List<AddresnapInfo> makeCopyHook(EmpnapInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<AddresnapInfo> results = new ArrayList<>();
		
		for (AddressInfo eachRecod : source.addresses) {
			AddresnapInfo clonedRecord = AddresnapInfo.copyFrom(eachRecod);
			results.add(clonedRecord);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(EmpnapInfo source) {
		if (source.addresses == null)
			return false;
		
		if (source.addresses.isEmpty())
			return false;
		
		return true;
	}
}
