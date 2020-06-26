package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoUniquifier;

final class StolisUniquifier implements InfoUniquifier<StolisInfo> {
	
	@Override public List<StolisInfo> uniquify(List<StolisInfo> infoRecords) {
		List<StolisInfo> results = new ArrayList<>();
		
		for (StolisInfo eachRecord : infoRecords) {
			StolisInfo result = makeClone(eachRecord);
			
			result = uniquifyPhone(result);
			
			results.add(result);
		}
		
		return results.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private StolisInfo uniquifyPhone(StolisInfo result) {
		if (result.phones == null)
			return result;
		
		List<PhoneInfo> allPhones = new ArrayList<>(result.phones);
		allPhones = allPhones.stream().distinct().collect(Collectors.toList());			
		
		result.phones = allPhones;
		return result;
	}
	
	
	
	private StolisInfo makeClone(StolisInfo infoRecord) {
		try {
			return (StolisInfo) infoRecord.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
