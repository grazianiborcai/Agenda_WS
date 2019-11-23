package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmMergerStowotm extends InfoMergerTemplate<EmpwotmInfo, StowotmInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, StowotmInfo> getVisitorHook() {
		return new EmpwotmVisiMergeStowotm();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
