package br.com.gda.business.employeeSnapshot.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoUniquifier;

final class EmpnapUniquifier implements InfoUniquifier<EmpnapInfo> {
	
	@Override public List<EmpnapInfo> uniquify(List<EmpnapInfo> infoRecords) {
		List<EmpnapInfo> uniques = new ArrayList<>();		
		
		for (EmpnapInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				EmpnapInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddresnap(duple, eachRecord);
				uniquifyPhonap(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAddresnap(EmpnapInfo duple, EmpnapInfo eachRecord) {
		List<AddresnapInfo> allAddresses = new ArrayList<>();
		
		allAddresses.addAll(duple.addresnaps);
		allAddresses.addAll(eachRecord.addresnaps);
		
		duple.addresnaps = allAddresses.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyPhonap(EmpnapInfo duple, EmpnapInfo eachRecord) {
		List<PhonapInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phonaps);
		allPhones.addAll(eachRecord.phonaps);
		
		duple.phonaps = allPhones.stream().distinct().collect(Collectors.toList());
	}
}
