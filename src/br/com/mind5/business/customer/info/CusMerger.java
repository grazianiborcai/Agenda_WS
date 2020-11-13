package br.com.mind5.business.customer.info;


import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusMerger {
	public static List<CusInfo> mergeWithSytotauh(List<CusInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeSytotauh());
		InfoMerger<CusInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithUserarch(List<CusInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, UserarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeUserarch());
		InfoMerger<CusInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithFimist(List<CusInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeFimist());
		InfoMerger<CusInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithCusnap(List<CusInfo> baseInfos, List<CusnapInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, CusnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeCusnap());
		InfoMerger<CusInfo, CusnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithAddress(List<CusInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeAddress());
		InfoMerger<CusInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithCusarch(List<CusInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, CusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeCusarch());
		InfoMerger<CusInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithPerson(List<CusInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergePerson());
		InfoMerger<CusInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithPhone(List<CusInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergePhone());
		InfoMerger<CusInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithUser(List<CusInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeUser());
		InfoMerger<CusInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeWithUsername(List<CusInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeUsername());
		InfoMerger<CusInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeToDelete(List<CusInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, CusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeToDelete());
		InfoMerger<CusInfo, CusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeToSelect(List<CusInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, CusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeToSelect());
		InfoMerger<CusInfo, CusInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusInfo> mergeToUpdate(List<CusInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilder<CusInfo, CusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusVisiMergeToUpdate());
		InfoMerger<CusInfo, CusInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
