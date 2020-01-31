package br.com.mind5.business.employee.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpMergerFimist extends InfoMergerTemplate_<EmpInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, FimistInfo> getVisitorHook() {
		return new EmpVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
