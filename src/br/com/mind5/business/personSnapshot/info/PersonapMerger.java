package br.com.mind5.business.personSnapshot.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.gender.info.GenderInfo;

public final class PersonapMerger {	
	public static PersonapInfo mergeWithGender(GenderInfo sourceOne, PersonapInfo sourceTwo) {
		InfoMerger_<PersonapInfo, GenderInfo> merger = new PersonapMergerGender();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonapInfo> mergeWithGender(List<GenderInfo> sourceOnes, List<PersonapInfo> sourceTwos) {
		InfoMerger_<PersonapInfo, GenderInfo> merger = new PersonapMergerGender();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
