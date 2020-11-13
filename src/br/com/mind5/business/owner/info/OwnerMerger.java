package br.com.mind5.business.owner.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OwnerMerger {
	public static List<OwnerInfo> mergeWithBusarea(List<OwnerInfo> baseInfos, List<BusareaInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, BusareaInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeBusarea());
		InfoMerger<OwnerInfo, BusareaInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithDaemon(List<OwnerInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeDaemon());
		InfoMerger<OwnerInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithFimist(List<OwnerInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeFimist());
		InfoMerger<OwnerInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeWithOwnerap(List<OwnerInfo> baseInfos, List<OwnerapInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, OwnerapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeOwnerap());
		InfoMerger<OwnerInfo, OwnerapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeWithAddress(List<OwnerInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeAddress());
		InfoMerger<OwnerInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeWithComp(List<OwnerInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, CompInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeComp());
		InfoMerger<OwnerInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeWithPerson(List<OwnerInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergePerson());
		InfoMerger<OwnerInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithPhone(List<OwnerInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergePhone());
		InfoMerger<OwnerInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithUser(List<OwnerInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeUser());
		InfoMerger<OwnerInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeWithUsername(List<OwnerInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeUsername());
		InfoMerger<OwnerInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeToSelect(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, OwnerInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeToSelect());
		InfoMerger<OwnerInfo, OwnerInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnerInfo> mergeToDelete(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, OwnerInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeToDelete());
		InfoMerger<OwnerInfo, OwnerInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OwnerInfo> mergeToUpdate(List<OwnerInfo> baseInfos, List<OwnerInfo> selectedInfos) {
		InfoMergerBuilder<OwnerInfo, OwnerInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnerVisiMergeToUpdate());
		InfoMerger<OwnerInfo, OwnerInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
