package br.com.mind5.business.customer.info;


import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusMerger {
	public static CusInfo mergeWithFimist(FimistInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, FimistInfo> merger = new CusMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, FimistInfo> merger = new CusMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
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
	
	
	
	public static CusInfo mergeWithDaemon(UserInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, UserInfo> merger = new CusMergerDaemon();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeWithDaemon(List<UserInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, UserInfo> merger = new CusMergerDaemon();		
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
	
	
	
	public static CusInfo mergeToUpdate(CusInfo sourceOne, CusInfo sourceTwo) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CusInfo> mergeToUpdate(List<CusInfo> sourceOnes, List<CusInfo> sourceTwos) {
		InfoMerger<CusInfo, CusInfo> merger = new CusMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
