package br.com.gda.payService.payCustomer.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoUniquifier;

final class PayCusUniquifier implements InfoUniquifier<PayCusInfo> {
	
	@Override public List<PayCusInfo> uniquify(List<PayCusInfo> infoRecords) {
		List<PayCusInfo> uniques = new ArrayList<>();		
		
		for (PayCusInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				PayCusInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAddress(PayCusInfo duple, PayCusInfo eachRecord) {
		List<AddressInfo> allAddresses = new ArrayList<>();
		
		allAddresses.addAll(duple.addresses);
		allAddresses.addAll(eachRecord.addresses);
		
		duple.addresses = allAddresses.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyPhone(PayCusInfo duple, PayCusInfo eachRecord) {
		List<PhoneInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phones);
		allPhones.addAll(eachRecord.phones);
		
		duple.phones = allPhones.stream().distinct().collect(Collectors.toList());
	}
}
