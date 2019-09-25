package br.com.gda.business.owner.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoUniquifier;

final class OwnerUniquifier implements InfoUniquifier<OwnerInfo> {
	
	@Override public List<OwnerInfo> uniquify(List<OwnerInfo> infoRecords) {
		List<OwnerInfo> uniques = new ArrayList<>();		
		
		for (OwnerInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				OwnerInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				uniquifyStolis(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAddress(OwnerInfo duple, OwnerInfo eachRecord) {
		List<AddressInfo> allAddresses = new ArrayList<>();
		
		allAddresses.addAll(duple.addresses);
		allAddresses.addAll(eachRecord.addresses);
		
		duple.addresses = allAddresses.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyPhone(OwnerInfo duple, OwnerInfo eachRecord) {
		List<PhoneInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phones);
		allPhones.addAll(eachRecord.phones);
		
		duple.phones = allPhones.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyStolis(OwnerInfo duple, OwnerInfo eachRecord) {
		List<StolisInfo> allOwntores = new ArrayList<>();
		
		allOwntores.addAll(duple.stolises);
		allOwntores.addAll(eachRecord.stolises);
		
		duple.stolises = allOwntores.stream().distinct().collect(Collectors.toList());
	}
}
