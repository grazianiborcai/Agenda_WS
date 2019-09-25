package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class OwnerMerger {
	public static OwnerInfo mergeWithOwnerap(OwnerapInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, OwnerapInfo> merger = new OwnerMergerOwnerap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeWithOwnerap(List<OwnerapInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, OwnerapInfo> merger = new OwnerMergerOwnerap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OwnerInfo mergeWithAddress(AddressInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, AddressInfo> merger = new OwnerMergerAddress();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeWithAddress(List<AddressInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, AddressInfo> merger = new OwnerMergerAddress();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OwnerInfo mergeWithComp(CompInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, CompInfo> merger = new OwnerMergerComp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeWithComp(List<CompInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, CompInfo> merger = new OwnerMergerComp();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OwnerInfo mergeWithStolis(StolisInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, StolisInfo> merger = new OwnerMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, StolisInfo> merger = new OwnerMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OwnerInfo mergeWithPerson(PersonInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, PersonInfo> merger = new OwnerMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, PersonInfo> merger = new OwnerMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerInfo mergeWithPhone(PhoneInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, PhoneInfo> merger = new OwnerMergerPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeWithPhone(List<PhoneInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, PhoneInfo> merger = new OwnerMergerPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerInfo mergeWithUser(UserInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, UserInfo> merger = new OwnerMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeWithUser(List<UserInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, UserInfo> merger = new OwnerMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerInfo mergeWithUsername(UsernameInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, UsernameInfo> merger = new OwnerMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, UsernameInfo> merger = new OwnerMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerInfo mergeToSelect(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, OwnerInfo> merger = new OwnerMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeToSelect(List<OwnerInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, OwnerInfo> merger = new OwnerMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerInfo mergeToDelete(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, OwnerInfo> merger = new OwnerMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeToDelete(List<OwnerInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, OwnerInfo> merger = new OwnerMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OwnerInfo mergeToUpdate(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		InfoMerger<OwnerInfo, OwnerInfo> merger = new OwnerMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OwnerInfo> mergeToUpdate(List<OwnerInfo> sourceOnes, List<OwnerInfo> sourceTwos) {
		InfoMerger<OwnerInfo, OwnerInfo> merger = new OwnerMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
