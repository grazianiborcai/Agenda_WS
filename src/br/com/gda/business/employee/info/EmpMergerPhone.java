package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;

final class EmpMergerPhone extends InfoMerger<EmpInfo, PhoneInfo, EmpInfo> {
	public EmpInfo merge(PhoneInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpVisiMergePhone());
	}
	
	
	
	public List<EmpInfo> merge(List<PhoneInfo> sourceOnes, List<EmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpVisiMergePhone());
	}
}
