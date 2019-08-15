package br.com.gda.business.customer.info;


import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class CusMerger {
	public static CusInfo mergeWithCusnap(CusnapInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, CusnapInfo> merger = new CusMergerCusnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithCusnap(List<CusnapInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, CusnapInfo> merger = new CusMergerCusnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeWithAddress(AddressInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, AddressInfo> merger = new CusMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, AddressInfo> merger = new CusMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeWithCusarch(CusarchInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, CusarchInfo> merger = new CusMergerCusarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithCusarch(List<CusarchInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, CusarchInfo> merger = new CusMergerCusarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeWithPerson(PersonInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, PersonInfo> merger = new CusMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, PersonInfo> merger = new CusMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeWithPhone(PhoneInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, PhoneInfo> merger = new CusMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, PhoneInfo> merger = new CusMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeWithUser(UserInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, UserInfo> merger = new CusMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithUser(List<UserInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, UserInfo> merger = new CusMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeWithUsername(UsernameInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, UsernameInfo> merger = new CusMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, UsernameInfo> merger = new CusMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeToDelete(CusInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeToDelete(List<CusInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeToSelect(CusInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeToSelect(List<CusInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeToUpdateUser(CusInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToUpdateUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeToUpdateUser(List<CusInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToUpdateUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CusInfo mergeToUpdate(CusInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeToUpdate(List<CusInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
