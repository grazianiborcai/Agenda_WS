package br.com.gda.business.employeeSnapshot.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

public final class EmpnapMerger {
	public static EmpnapInfo mergeWithAddress(AddressInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, AddressInfo> merger = new EmpnapMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, AddressInfo> merger = new EmpnapMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithPerson(PersonInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, PersonInfo> merger = new EmpnapMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, PersonInfo> merger = new EmpnapMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithPhone(PhoneInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, PhoneInfo> merger = new EmpnapMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, PhoneInfo> merger = new EmpnapMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithUser(UserInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, UserInfo> merger = new EmpnapMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithUser(List<UserInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, UserInfo> merger = new EmpnapMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeToSelect(EmpnapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, EmpnapInfo> merger = new EmpnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeToSelect(List<EmpnapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, EmpnapInfo> merger = new EmpnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
