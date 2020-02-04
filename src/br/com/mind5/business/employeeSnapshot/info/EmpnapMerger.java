package br.com.mind5.business.employeeSnapshot.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class EmpnapMerger {
	public static EmpnapInfo mergeWithUselis(UselisInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger_<EmpnapInfo, UselisInfo> merger = new EmpnapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger_<EmpnapInfo, UselisInfo> merger = new EmpnapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithPersolis(PersolisInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger_<EmpnapInfo, PersolisInfo> merger = new EmpnapMergerPersolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPersolis(List<PersolisInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger_<EmpnapInfo, PersolisInfo> merger = new EmpnapMergerPersolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithAddresnap(AddresnapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger_<EmpnapInfo, AddresnapInfo> merger = new EmpnapMergerAddresnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithAddresnap(List<AddresnapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger_<EmpnapInfo, AddresnapInfo> merger = new EmpnapMergerAddresnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithPersonap(PersonapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger_<EmpnapInfo, PersonapInfo> merger = new EmpnapMergerPersonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPersonap(List<PersonapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger_<EmpnapInfo, PersonapInfo> merger = new EmpnapMergerPersonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithPhonap(PhonapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger_<EmpnapInfo, PhonapInfo> merger = new EmpnapMergerPhonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPhonap(List<PhonapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger_<EmpnapInfo, PhonapInfo> merger = new EmpnapMergerPhonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeToSelect(EmpnapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger_<EmpnapInfo, EmpnapInfo> merger = new EmpnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeToSelect(List<EmpnapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger_<EmpnapInfo, EmpnapInfo> merger = new EmpnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
