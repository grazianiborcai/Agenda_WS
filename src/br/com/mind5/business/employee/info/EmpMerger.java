package br.com.mind5.business.employee.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpMerger {
	public static List<EmpInfo> mergeWithEmplutm(List<EmpInfo> baseInfos, List<EmplutmInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, EmplutmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiEmplutm());
		InfoMerger<EmpInfo, EmplutmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithEmpwotm(List<EmpInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, EmpwotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiEmpwotm());
		InfoMerger<EmpInfo, EmpwotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithUselis(List<EmpInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiUselis());
		InfoMerger<EmpInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithUserarch(List<EmpInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, UserarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiUserarch());
		InfoMerger<EmpInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithSytotauh(List<EmpInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiSytotauh());
		InfoMerger<EmpInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithEmparch(List<EmpInfo> baseInfos, List<EmparchInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, EmparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiEmparch());
		InfoMerger<EmpInfo, EmparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithPerarch(List<EmpInfo> baseInfos, List<PerarchInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, PerarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiPerarch());
		InfoMerger<EmpInfo, PerarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpInfo> mergeWithFimist(List<EmpInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiFimist());
		InfoMerger<EmpInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithAddress(List<EmpInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiAddress());
		InfoMerger<EmpInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithEmpnap(List<EmpInfo> baseInfos, List<EmpnapInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, EmpnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiEmpnap());
		InfoMerger<EmpInfo, EmpnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithPerson(List<EmpInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiPerson());
		InfoMerger<EmpInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithPhone(List<EmpInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiPhone());
		InfoMerger<EmpInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithUser(List<EmpInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiUser());
		InfoMerger<EmpInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeWithUsername(List<EmpInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiUsername());
		InfoMerger<EmpInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeToDelete(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, EmpInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiToDelete());
		InfoMerger<EmpInfo, EmpInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeToSelect(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, EmpInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiToSelect());
		InfoMerger<EmpInfo, EmpInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpInfo> mergeToUpdate(List<EmpInfo> baseInfos, List<EmpInfo> selectedInfos) {
		InfoMergerBuilder<EmpInfo, EmpInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpMergerVisiToUpdate());
		InfoMerger<EmpInfo, EmpInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
