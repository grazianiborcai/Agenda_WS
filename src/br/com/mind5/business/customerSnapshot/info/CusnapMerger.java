package br.com.mind5.business.customerSnapshot.info;


import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class CusnapMerger {
	public static CusnapInfo mergeWithUselis(UselisInfo sourceOne, CusnapInfo sourceTwo) {
		InfoMerger_<CusnapInfo, UselisInfo> merger = new CusnapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusnapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<CusnapInfo> sourceTwos) {
		InfoMerger_<CusnapInfo, UselisInfo> merger = new CusnapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusnapInfo mergeWithPerson(PersonInfo sourceOne, CusnapInfo sourceTwo) {
		InfoMerger_<CusnapInfo, PersonInfo> merger = new CusnapMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusnapInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<CusnapInfo> sourceTwos) {
		InfoMerger_<CusnapInfo, PersonInfo> merger = new CusnapMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CusnapInfo mergeToSelect(CusnapInfo sourceOne, CusnapInfo sourceTwo) {
		InfoMerger_<CusnapInfo, CusnapInfo> merger = new CusnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusnapInfo> mergeToSelect(List<CusnapInfo> sourceOnes, List<CusnapInfo> sourceTwos) {
		InfoMerger_<CusnapInfo, CusnapInfo> merger = new CusnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
