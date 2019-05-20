package br.com.gda.business.personSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.info.InfoMerger;

public final class PersonapMerger {	
	public static PersonapInfo mergeWithGender(GenderInfo sourceOne, PersonapInfo sourceTwo) {
		InfoMerger<PersonapInfo, GenderInfo> merger = new PersonapMergerGender();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonapInfo> mergeWithGender(List<GenderInfo> sourceOnes, List<PersonapInfo> sourceTwos) {
		InfoMerger<PersonapInfo, GenderInfo> merger = new PersonapMergerGender();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
