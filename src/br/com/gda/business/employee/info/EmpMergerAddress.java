package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger_;

final class EmpMergerAddress extends InfoMerger_<EmpInfo, AddressInfo, EmpInfo> {
	public EmpInfo merge(AddressInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpVisiMergeAddress());
	}
	
	
	
	public List<EmpInfo> merge(List<AddressInfo> sourceOnes, List<EmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpVisiMergeAddress());
	}
}
