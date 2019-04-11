package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoMerger;

final class EmpwotmMergerStowotm extends InfoMerger<EmpwotmInfo, EmposInfo, StowotmInfo> {
	public EmpwotmInfo merge(EmposInfo sourceOne, StowotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpwotmVisiMergeStowotm());
	}
	
	
	
	public List<EmpwotmInfo> merge(List<EmposInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new EmpwotmVisiMergeStowotm());
	}
}
