package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class PhoneCopyEmp extends InfoCopierOneToManyTemplate<PhoneInfo, EmpInfo> {
	
	public PhoneCopyEmp() {
		super();
	}
	
	
	
	@Override protected List<PhoneInfo> makeCopyHook(EmpInfo source) {
		List<PhoneInfo> results = new ArrayList<>();		
		
		if (shouldCopy(source) == false)
			return results;				
		
		for (PhoneInfo eachRecod : source.phones) {
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(EmpInfo source) {
		if (source.phones == null)
			return false;
		
		if (source.phones.isEmpty())
			return false;
		
		return true;
	}
}
