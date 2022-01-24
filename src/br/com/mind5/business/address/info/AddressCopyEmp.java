package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class AddressCopyEmp extends InfoCopierOneToManyTemplate<AddressInfo, EmpInfo> {
	
	public AddressCopyEmp() {
		super();
	}
	
	
	
	@Override protected List<AddressInfo> makeCopyHook(EmpInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<AddressInfo> results = new ArrayList<>();
		
		for (AddressInfo eachRecod : source.addresses) {
			AddressInfo clonedRecord = makeClone(eachRecod);
			results.add(clonedRecord);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(EmpInfo source) {
		if (source.addresses == null)
			return false;
		
		if (source.addresses.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
		} catch (Exception e) {
			super.logException(e);
			throw new IllegalStateException(e); 
		}
	}
}
