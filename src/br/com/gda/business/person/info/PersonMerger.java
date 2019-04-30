package br.com.gda.business.person.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class PersonMerger {
	public static PersonInfo mergeWithGender(GenderInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger<PersonInfo, GenderInfo> merger = new PersonMergerGender();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeWithGender(List<GenderInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger<PersonInfo, GenderInfo> merger = new PersonMergerGender();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PersonInfo mergeWithUsername(UsernameInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger<PersonInfo, UsernameInfo> merger = new PersonMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger<PersonInfo, UsernameInfo> merger = new PersonMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PersonInfo mergeToDelete(PersonInfo sourceOne, PersonInfo sourceTwo) {
		InfoMerger<PersonInfo, PersonInfo> merger = new PersonMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersonInfo> mergeToDelete(List<PersonInfo> sourceOnes, List<PersonInfo> sourceTwos) {
		InfoMerger<PersonInfo, PersonInfo> merger = new PersonMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
