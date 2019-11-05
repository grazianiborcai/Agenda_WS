package br.com.mind5.business.employee.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpMergerFimist extends InfoMergerTemplate<EmpInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, FimistInfo> getVisitorHook() {
		return new EmpVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
