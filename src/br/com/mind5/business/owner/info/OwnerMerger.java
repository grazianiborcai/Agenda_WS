package br.com.mind5.business.owner.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OwnerMerger {
	public static List<OwnerInfo> mergeWithDaemon(List<OwnerInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeDaemon());
		InfoMergerV3<OwnerInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithFimist(List<OwnerInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeFimist());
		InfoMergerV3<OwnerInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeWithOwnerap(List<OwnerInfo> baseInfos, List<OwnerapInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, OwnerapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeOwnerap());
		InfoMergerV3<OwnerInfo, OwnerapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeWithAddress(List<OwnerInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeAddress());
		InfoMergerV3<OwnerInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeWithComp(List<OwnerInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, CompInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeComp());
		InfoMergerV3<OwnerInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeWithPerson(List<OwnerInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergePerson());
		InfoMergerV3<OwnerInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithPhone(List<OwnerInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergePhone());
		InfoMergerV3<OwnerInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithUser(List<OwnerInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeUser());
		InfoMergerV3<OwnerInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithUsername(List<OwnerInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeUsername());
		InfoMergerV3<OwnerInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeToSelect(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, OwnerInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeToSelect());
		InfoMergerV3<OwnerInfo, OwnerInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeToDelete(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, OwnerInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeToDelete());
		InfoMergerV3<OwnerInfo, OwnerInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeToUpdate(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnerInfo, OwnerInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeToUpdate());
		InfoMergerV3<OwnerInfo, OwnerInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
