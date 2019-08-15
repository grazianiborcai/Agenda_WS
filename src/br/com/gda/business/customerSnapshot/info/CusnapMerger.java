package br.com.gda.business.customerSnapshot.info;


import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger;

public final class CusnapMerger {
	public static CusnapInfo mergeWithPerson(PersonInfo sourceOne, CusnapInfo sourceTwo) {
		InfoMerger<CusnapInfo, PersonInfo> merger = new CusnapMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusnapInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<CusnapInfo> sourceTwos) {
		InfoMerger<CusnapInfo, PersonInfo> merger = new CusnapMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusnapInfo mergeToSelect(CusnapInfo sourceOne, CusnapInfo sourceTwo) {
		InfoMerger<CusnapInfo, CusnapInfo> merger = new CusnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusnapInfo> mergeToSelect(List<CusnapInfo> sourceOnes, List<CusnapInfo> sourceTwos) {
		InfoMerger<CusnapInfo, CusnapInfo> merger = new CusnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
